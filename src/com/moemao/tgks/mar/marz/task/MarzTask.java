package com.moemao.tgks.mar.marz.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.moemao.tgks.common.core.spring.ContextUtil;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.mar.execute.MarzRequest;
import com.moemao.tgks.mar.marz.tool.MarzConstant;
import com.moemao.tgks.mar.marz.tool.MarzUtil;
import com.moemao.tgks.mar.marzaccount.entity.MarzAccountEvt;
import com.moemao.tgks.mar.marzaccount.service.MarzAccountService;
import com.moemao.tgks.mar.marzlog.service.MarzLogService;
import com.moemao.tgks.mar.marzmap.entity.MarzMapEvt;
import com.moemao.tgks.mar.marzsetting.entity.MarzSettingEvt;
import com.moemao.tgks.mar.marzsetting.entity.MarzSettingReq;
import com.moemao.tgks.mar.marzsetting.service.MarzSettingService;
import com.moemao.tgks.mar.tool.MarConstant;

public class MarzTask implements Runnable, ApplicationContextAware
{
    private static Log logger = LogFactory.getLog(MarzTask.class);
    
    private MarzRequest request = MarzRequest.getInstance();
    
    private MarzAccountService marzAccountService;
    
    private MarzLogService marzLogService;
    
    private MarzSettingService marzSettingService;
    
    private MarzSettingEvt marzSettingEvt;
    
    private MarzAccountEvt account;
    
    private Map<String, JSONObject> map;
    
    private String sid;
    
    private int resultCode = MarzConstant.SUCCESS;
    
    public MarzTask(MarzAccountEvt marzAccountEvt)
    {
        account = marzAccountEvt;
    }

    @Override
    public void run()
    {
        marzAccountService = (MarzAccountService) ContextUtil.getBean("mar_marzAccountService");
        marzLogService = (MarzLogService) ContextUtil.getBean("mar_marzLogService");
        marzSettingService = (MarzSettingService) ContextUtil.getBean("mar_marzSettingService");
        
        // 默认线程调用的执行方法
        System.out.println("执行任务开始 ID：" + account.getId());
        
        this.initSetting();
        
        // 尽量保证流程上的简洁 run流程只负责调用以及返回失败时的处理 并不做各个条件判断的限制
        
        // 1、账号登陆
        if (CommonUtil.isEmpty(account.getSessionId()))
        {
            resultCode = this.login();
            
            if (MarzConstant.SUCCESS > resultCode)
            {
                System.out.println("发生了错误！当前resultCode：" + resultCode);
                
                resultCode = this.login();
                
                if (MarzConstant.SUCCESS > resultCode)
                {
                    // 2次登陆失败 该账号无法执行 直接返回
                    return;
                }
            }
        }
        else
        {
            // 当前的逻辑 每次扫描出的任务如果包含sid 则跳过登录
            // 在用户操作下线的时候 将account的sid一同清空即可
            // 如果sid已经失效 会在下面的homeShow中重新登录
            sid = account.getSessionId();
        }
        
        
        // 2、更新当前账号基础数据
        resultCode = this.baseInfo();
        
        if (MarzConstant.SUCCESS > resultCode)
        {
            System.out.println("发生了错误！当前resultCode：" + resultCode);
            
            resultCode = this.login();
            resultCode = this.baseInfo();
            
            if (MarzConstant.SUCCESS > resultCode)
            {
                return;
            }
        }
        
        // 3、探索
        resultCode = this.explore();
        
        // 4、卡片处理
        resultCode = this.card();
        
        // 5、战斗
        resultCode = this.battle();
        
        // 最后要保存一下sessionId
        account.setSessionId(sid);
        this.marzAccountService.updateMarzAccount(account);
        
        System.out.println("执行任务结束 ID：" + account.getId());
    }
    
    private void initSetting()
    {
        String tgksId = account.getTgksId();
        marzSettingEvt = new MarzSettingEvt();
        marzSettingEvt.setTgksId(tgksId);
        MarzSettingReq marzSettingReq = new MarzSettingReq();
        marzSettingReq.setTgksId(tgksId);
        
        List<MarzSettingEvt> marzSettinglist = this.marzSettingService.queryMarzSetting(marzSettingReq);
        
        if (!CommonUtil.isEmpty(marzSettinglist))
        {
            for (MarzSettingEvt setting : marzSettinglist)
            {
                if (MarzConstant.VALIDATE_SETTING_EXPLORE == Integer.parseInt(setting.getName()))
                {
                    marzSettingEvt.setExplore(setting.getValue());
                }
                else if (MarzConstant.VALIDATE_SETTING_CARDSELL == Integer.parseInt(setting.getName()))
                {
                    marzSettingEvt.setCardSell(setting.getValue());
                }
                else if (MarzConstant.VALIDATE_SETTING_CARDSELL_COMMON == Integer.parseInt(setting.getName()))
                {
                    marzSettingEvt.setCardSellCommon(setting.getValue());
                }
                else if (MarzConstant.VALIDATE_SETTING_CARDFUSION == Integer.parseInt(setting.getName()))
                {
                    marzSettingEvt.setCardFusion(setting.getValue());
                }
                else if (MarzConstant.VALIDATE_SETTING_BATTLE == Integer.parseInt(setting.getName()))
                {
                    marzSettingEvt.setBattle(setting.getValue());
                }
                else if (MarzConstant.VALIDATE_SETTING_BATTLE_NOWASTE == Integer.parseInt(setting.getName()))
                {
                    marzSettingEvt.setBattleNowaste(setting.getValue());
                }
            }
        }
    }
    
    /**
     * 
     * @Title: login
     * @Description: 账户登陆 login+connect
     * @return void 返回类型
     * @throws
     */
    private int login()
    {
        try
        {
            if (MarzConstant.MARZ_ACCOUNT_TYPE_0.equals(account.getType()))
            {
                map = request.loginIOS(account.getIosUuid(), account.getIosKey());
            }
            else if (MarzConstant.MARZ_ACCOUNT_TYPE_1.equals(account.getType()))
            {
                map = request.loginAndroid(account.getAndroidUuid(), account.getAndroidKey());
            }
            else
            {
                map = request.loginIOS(account.getIosUuid(), account.getIosKey());
            }
            
            resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
            
            this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_0, "账号登录" + MarzUtil.resultCodeStr(resultCode));
            
            if (MarzConstant.RES_CODE_0 == resultCode)
            {
                sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                
                map = request.connect(sid);
                
                account.setSessionId(sid);
                //sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
            }
        }
        catch (Exception e)
        {
            System.out.println("登陆失败！退出任务");
            return MarzConstant.FAILED;
        }
        
        return resultCode;
    }
    
    private int baseInfo()
    {
        try
        {
            map = request.homeShow(sid);
            
            resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
            
            this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_0, "账号基本信息更新" + MarzUtil.resultCodeStr(resultCode));
            
            if (MarzConstant.RES_CODE_0 == resultCode)
            {
                sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                
                JSONObject user = map.get(MarzConstant.JSON_TAG_HOMWSHOW);
                account.setAp(user.getJSONObject("user").getInt("ap"));
                account.setApMax(user.getJSONObject("user").getInt("ap_max"));
                account.setBp(user.getJSONObject("user").getInt("bp"));
                account.setBpMax(user.getJSONObject("user").getInt("bp_max"));
                account.setCardMax(user.getJSONObject("user").getInt("card_max"));
                account.setCardNum(user.getJSONObject("user").getInt("card_num"));
                account.setCoin(user.getJSONObject("user").getInt("coin") + user.getJSONObject("user").getInt("coin_free"));
                account.setFp(user.getJSONObject("user").getInt("fp"));
                account.setGold(user.getJSONObject("user").getInt("gold"));
                account.setLv(user.getJSONObject("user").getInt("lv"));
                account.setName(user.getJSONObject("user").getString("name"));
                account.setUserId(user.getJSONObject("user").getString("userid"));
                
                account.setSessionId(sid);
                this.marzAccountService.updateMarzAccount(account);
            }
        }
        catch (Exception e)
        {
            return MarzConstant.FAILED;
        }
        
        return resultCode;
    }
    
    private int explore()
    {
        // 在开头加入条件限制
        if (!validateSetting(MarzConstant.VALIDATE_SETTING_EXPLORE) || account.getAp() == 0)
        {
            return MarzConstant.SUCCESS;
        }
        
        try
        {
            // 接口设计的是可以根据职业来做 不过这个没啥意义 就写死了
            request.exploreStart(sid, "1", "0");
            
            map = request.exploreEnd(sid);
            
            resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
            
            this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_2, "探索" + MarzUtil.resultCodeStr(resultCode));
            
            if (MarzConstant.RES_CODE_0 == resultCode)
            {
                sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                
                JSONObject user = map.get(MarzConstant.JSON_TAG_EXPLOREEND);
                account.setAp(user.getJSONObject("user").getInt("ap"));
                account.setApMax(user.getJSONObject("user").getInt("ap_max"));
                account.setCardMax(user.getJSONObject("user").getInt("card_max"));
                account.setCardNum(user.getJSONObject("user").getInt("card_num"));
                account.setGold(user.getJSONObject("user").getInt("gold"));
            }
        }
        catch (Exception e)
        {
            return MarzConstant.FAILED;
        }
        
        return resultCode;
    }
    
    /**
     * 
     * @Title: card
     * @Description: 卡片处理 合成 出售等
     * @return
     * @return int 返回类型
     * @throws
     */
    private int card()
    {
        try
        {
            // 更新卡片信息
            map = request.cardShow(sid);
            
            resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
            
            //this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_0, "卡片信息更新" + MarzUtil.resultCodeStr(resultCode));
            
            if (MarzConstant.RES_CODE_0 == resultCode)
            {
                sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                
                JSONObject card = map.get(MarzConstant.JSON_TAG_CARDSHOW);
                JSONArray cards = card.getJSONArray("cards");
                
                List<String> cardSellList = new ArrayList<String>();
                List<String> cardFusionList = new ArrayList<String>();
                JSONObject cardJSON;
                
                // 自动卖卡
                if (validateSetting(MarzConstant.VALIDATE_SETTING_CARDSELL))
                {
                    // 查询用户设定的售卡列表
                    // TODO
                    List<String> userSellList = new ArrayList<String>();
                    
                    // 遍历所有卡片 把需要出售的卡片ID放入cardSellList
                    for (int i = 0; i < cards.size(); i++)
                    {
                        cardJSON = JSONObject.fromObject(cards.get(i));
                        // 只能出售未锁定以及是1级的卡
                        if (0 == cardJSON.getInt("is_lock") && 1 == cardJSON.getInt("lv"))
                        {
                            // 先卖 出售列表中的卡
                            if (userSellList.contains(cardJSON.getString("cardid")))
                            {
                                cardSellList.add(cardJSON.getString("uniqid"));
                            }
                            // 然后卖一些基础的垃圾卡 10~30
                            else if (validateSetting(MarzConstant.VALIDATE_SETTING_CARDSELL_COMMON)
                                    && cardJSON.getInt("lv_max") >= 10 && cardJSON.getInt("lv_max") <= 30)
                            {
                                cardSellList.add(cardJSON.getString("uniqid"));
                            }
                        }
                        
                        // 当出售的卡片满10张时 跳出
                        if (cardSellList.size() == 10)
                        {
                            break;
                        }
                    }
                    
                    // 组装卡牌ID调用cardSell请求
                    if (cardSellList.size() > 0)
                    {
                        map = request.cardSell(sid, MarzUtil.listToString(cardSellList));
                        
                        resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
                        
                        this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_5, "卡片出售" + MarzUtil.resultCodeStr(resultCode));
                        
                        if (MarzConstant.RES_CODE_0 == resultCode)
                        {
                            sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                            
                            account.setCardNum(map.get(MarzConstant.JSON_TAG_CARDSELL).getInt("card_num"));
                            account.setGold(account.getGold() + map.get(MarzConstant.JSON_TAG_CARDSELL).getInt("get_gold"));
                            
                            this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_5, "已卖出卡片ID " + MarzUtil.listToString(cardSellList));
                        }
                    }
                }
                
                // 狗粮合成
                if (validateSetting(MarzConstant.VALIDATE_SETTING_CARDFUSION))
                {
                    // 只自动喂 蓝狗 红狗 粉狗
                    String[] chiari = {"20000001", "20000002", "20000003"};
                    String baseId = "";
                    
                    for (int i = 0; i < cards.size(); i++)
                    {
                        cardJSON = JSONObject.fromObject(cards.get(i));
                        
                        // 自动合成只支持SR UR跟MR 而且必须手动锁上
                        if (cardJSON.getInt("lv_max") >= 40 && cardJSON.getInt("lv") < cardJSON.getInt("lv_max")
                                && 0 != cardJSON.getInt("is_lock"))
                        {
                            baseId = cardJSON.getString("uniqid");
                        }
                        // 狗粮 一次喂4个 不能是已经出售了的
                        else if (!cardSellList.contains(cardJSON.getString("uniqid")) 
                                && Arrays.asList(chiari).contains(cardJSON.getString("cardid"))
                                && cardFusionList.size() < 4)
                        {
                            cardFusionList.add(cardJSON.getString("uniqid"));
                        }
                        
                        if (!CommonUtil.isEmpty(baseId) && cardFusionList.size() == 4)
                        {
                            break;
                        }
                    }
                    
                    if (!CommonUtil.isEmpty(baseId) && cardFusionList.size() > 0)
                    {
                        map = request.cardFusion(sid, baseId, MarzUtil.listToString(cardFusionList));
                        
                        resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
                        
                        this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_4, "卡片合成" + MarzUtil.resultCodeStr(resultCode));
                        
                        if (MarzConstant.RES_CODE_0 == resultCode)
                        {
                            sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                            
                            account.setCardNum(map.get(MarzConstant.JSON_TAG_CARDFUSION).getInt("card_num"));
                            account.setGold(map.get(MarzConstant.JSON_TAG_CARDFUSION).getInt("gold"));
                            
                            this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_4, "主卡ID " + baseId + " 消耗狗粮 " + MarzUtil.listToString(cardFusionList));
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            return MarzConstant.FAILED;
        }
        
        return resultCode;
    }
    
    private int battle()
    {
        if (!validateSetting(MarzConstant.VALIDATE_SETTING_BATTLE) && account.getAp() <= 5)
        {
            return MarzConstant.SUCCESS;
        }
        
        try
        {
            // 先查询单人战斗信息
            map = request.teamBattleSoloShow(sid);
            
            resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
            
            this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_1, "战斗信息查询" + MarzUtil.resultCodeStr(resultCode));
            
            if (MarzConstant.RES_CODE_0 == resultCode)
            {
                sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                
                List<MarzMapEvt> battleMapList = new ArrayList<MarzMapEvt>();
                MarzMapEvt mapEvt = new MarzMapEvt();
                
                JSONObject mapJSON;
                JSONArray bossArray;
                JSONObject bossJSON;

                String arthur1 = "";
                String arthur2 = "";
                String arthur4 = "";
                
                JSONArray battleMapNormal = map.get(MarzConstant.JSON_TAG_TEAMBATTLESOLOSHOW).getJSONArray("normal_groups");                
                JSONArray battleMapEvent = map.get(MarzConstant.JSON_TAG_TEAMBATTLESOLOSHOW).getJSONArray("event_groups");
                JSONArray arthurs = map.get(MarzConstant.JSON_TAG_TEAMBATTLESOLOSHOW).getJSONArray("arthurs");
                JSONObject arthur;
                
                // 整理当前可以战斗的BOSSID Normal
                for (int i = 0; i < battleMapNormal.size(); i++)
                {
                    mapJSON = JSONObject.fromObject(battleMapNormal.get(i));
                    
                    if (!CommonUtil.isEmpty(mapJSON.getString("bosses")))
                    {
                        bossArray = mapJSON.getJSONArray("bosses");
                        
                        for (int j = 0; j < bossArray.size(); j++)
                        {
                            bossJSON = JSONObject.fromObject(bossArray.get(j));
                            
                            mapEvt = new MarzMapEvt();
                            mapEvt.setBossId(bossJSON.getString("bossid"));
                            mapEvt.setBossName(mapJSON.getString("name") + " " + bossJSON.getString("difficulty"));
                            mapEvt.setBpCost(bossJSON.getInt("bp_use"));
                            mapEvt.setTarget(0);
                            battleMapList.add(mapEvt);
                        }
                    }
                }
                
                // 整理当前可以战斗的BOSSID Event
                for (int i = 0; i < battleMapEvent.size(); i++)
                {
                    mapJSON = JSONObject.fromObject(battleMapEvent.get(i));
                    
                    if (!CommonUtil.isEmpty(mapJSON.getString("bosses")))
                    {
                        bossArray = mapJSON.getJSONArray("bosses");
                        
                        for (int j = 0; j < bossArray.size(); j++)
                        {
                            bossJSON = JSONObject.fromObject(bossArray.get(j));
                            
                            mapEvt = new MarzMapEvt();
                            mapEvt.setBossId(bossJSON.getString("bossid"));
                            mapEvt.setBossName(mapJSON.getString("name") + " " + bossJSON.getString("difficulty"));
                            mapEvt.setBpCost(bossJSON.getInt("bp_use"));
                            
                            // 狗粮本跟每日限定要塞成0
                            if (MarConstant.BATTLE_START_CHIARI.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_MONDAY.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_TUESDAY.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_WEDNESDAY.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_THURSDAY.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_FRIDAY.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_SATURDAY.equals(bossJSON.getString("bossid"))
                                    || MarConstant.BATTLE_START_SUNDAY.equals(bossJSON.getString("bossid")))
                            {
                                mapEvt.setTarget(0);
                            }
                            else
                            {
                                mapEvt.setTarget(4);
                            }
                            
                            battleMapList.add(mapEvt);
                        }
                    }
                }
                
                // 处理4个NPC亚瑟的ID
                for (int i = 0; i < arthurs.size(); i++)
                {
                    arthur = JSONObject.fromObject(arthurs.get(i));
                    
                    if (1 == arthur.getInt("arthur_type"))
                    {
                        arthur1 = JSONObject.fromObject(arthur.getJSONArray("partners").get(0)).getString("userid");
                    }
                    else if (2 == arthur.getInt("arthur_type"))
                    {
                        arthur2 = JSONObject.fromObject(arthur.getJSONArray("partners").get(0)).getString("userid");
                    }
                    else if (3 == arthur.getInt("arthur_type"))
                    {
                        //arthur3 = JSONObject.fromObject(arthur.getJSONArray("partners").get(0)).getString("userid");
                    }
                    else if (4 == arthur.getInt("arthur_type"))
                    {
                        arthur4 = JSONObject.fromObject(arthur.getJSONArray("partners").get(0)).getString("userid");
                    }
                }
                
                // 判断应该打哪张图
                List<String> userMapList = MarzUtil.stringToList(account.getBossIds());
                mapEvt = new MarzMapEvt();
                
                for (String id : userMapList)
                {
                    for (MarzMapEvt m : battleMapList)
                    {
                        if (id.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                        {
                            mapEvt = m;
                        }
                    }
                }
                
                if (CommonUtil.isEmpty(mapEvt.getBossId()))
                {
                    // 没有可以打的副本时
                    // 是否启用不浪费BP
                    if (validateSetting(MarzConstant.VALIDATE_SETTING_BATTLE_NOWASTE) && (account.getBpMax() - account.getBp()) < 3)
                    {
                        for (MarzMapEvt m : battleMapList)
                        {
                            if (MarConstant.BATTLE_START_MONDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                            else if (MarConstant.BATTLE_START_TUESDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                            else if (MarConstant.BATTLE_START_WEDNESDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                            else if (MarConstant.BATTLE_START_THURSDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                            else if (MarConstant.BATTLE_START_FRIDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                            else if (MarConstant.BATTLE_START_SATURDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                            else if (MarConstant.BATTLE_START_SUNDAY.equals(m.getBossId()) && account.getBp() >= m.getBpCost())
                            {
                                mapEvt = m;
                            }
                        }
                    }
                    else
                    {
                        return MarzConstant.SUCCESS;
                    }
                }
                
                // 校验数据
                if (!CommonUtil.isEmpty(mapEvt.getBossId()))
                {
                    map = request.teamBattleSoloStart(sid, mapEvt.getBossId(), arthur1, arthur2, arthur4);
                    
                    resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
                    
                    this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_1, "战斗开始" + MarzUtil.resultCodeStr(resultCode) + " 目标副本 " + mapEvt.getBossName());
                    
                    if (MarzConstant.RES_CODE_0 == resultCode)
                    {
                        sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                        
                        String battleEndParam = "";
                        if (0 == mapEvt.getTarget())
                        {
                            battleEndParam = MarConstant.BATTLESOLOEND_3;
                        }
                        else
                        {
                            if (MarzConstant.MARZ_ACCOUNT_VIP_0.equals(account.getVip()))
                            {
                                battleEndParam = MarConstant.BATTLESOLOEND_1_2;
                            }
                            else if (MarzConstant.MARZ_ACCOUNT_VIP_1.equals(account.getVip()))
                            {
                                battleEndParam = MarConstant.BATTLESOLOEND_1_3;
                            }
                            else if (MarzConstant.MARZ_ACCOUNT_VIP_2.equals(account.getVip()))
                            {
                                battleEndParam = MarConstant.BATTLESOLOEND_1_4;
                            }
                            else if (MarzConstant.MARZ_ACCOUNT_VIP_3.equals(account.getVip()))
                            {
                                battleEndParam = MarConstant.BATTLESOLOEND_1_5;
                            }
                        }
                        
                        Thread.sleep(MarzConstant.SLEEPTIME_BATTLE_SOLO);
                        
                        map = request.teamBattleSoloEnd(sid, battleEndParam);
                        
                        resultCode = map.get(MarzConstant.JSON_TAG_RESCODE).getInt(MarzConstant.JSON_TAG_RESCODE);
                        
                        this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_1, "战斗结束" + MarzUtil.resultCodeStr(resultCode) + " 目标副本 " + mapEvt.getBossName());
                        
                        if (MarzConstant.RES_CODE_0 == resultCode)
                        {
                            sid = map.get(MarzConstant.JSON_TAG_SID).getString(MarzConstant.JSON_TAG_SID);
                            
                            JSONObject user = map.get(MarzConstant.JSON_TAG_TEAMBATTLESOLOEND);
                            account.setAp(user.getJSONObject("user").getInt("ap"));
                            account.setApMax(user.getJSONObject("user").getInt("ap_max"));
                            account.setBp(user.getJSONObject("user").getInt("bp"));
                            account.setBpMax(user.getJSONObject("user").getInt("bp_max"));
                            account.setCardMax(user.getJSONObject("user").getInt("card_max"));
                            account.setCardNum(user.getJSONObject("user").getInt("card_num"));
                            account.setCoin(user.getJSONObject("user").getInt("coin") + user.getJSONObject("user").getInt("coin_free"));
                            account.setFp(user.getJSONObject("user").getInt("fp"));
                            account.setGold(user.getJSONObject("user").getInt("gold"));
                            account.setLv(user.getJSONObject("user").getInt("lv"));
                            account.setName(user.getJSONObject("user").getString("name"));
                            account.setUserId(user.getJSONObject("user").getString("userid"));
                        }
                    }
                }
                else
                {
                    this.marzLogService.marzLog(account, MarzConstant.MARZ_LOG_TYPE_1, "当前时间没有找到适合战斗的副本，返回并等待BP恢复！");
                }
            }
        }
        catch (Exception e)
        {
            CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, String.format("战斗过程中发生异常！"));
            return MarzConstant.FAILED;
        }
        
        return resultCode;
    }
    
    private boolean validateSetting(int settingTag)
    {
        switch (settingTag)
        {
            case MarzConstant.VALIDATE_SETTING_EXPLORE: // 自动跑图开关
                return MarzConstant.MARZSETTING_ON.equals(marzSettingEvt.getExplore());
            case MarzConstant.VALIDATE_SETTING_CARDSELL: // 自动卖卡开关
                return MarzConstant.MARZSETTING_ON.equals(marzSettingEvt.getCardSell());
            case MarzConstant.VALIDATE_SETTING_CARDSELL_COMMON: // 自动卖卡开关-卖普通卡
                return MarzConstant.MARZSETTING_ON.equals(marzSettingEvt.getCardSellCommon());
            case MarzConstant.VALIDATE_SETTING_CARDFUSION: // 自动合成开关
                return MarzConstant.MARZSETTING_ON.equals(marzSettingEvt.getCardFusion());
            case MarzConstant.VALIDATE_SETTING_BATTLE: // 自动战斗开关
                return MarzConstant.MARZSETTING_ON.equals(marzSettingEvt.getBattle());
            case MarzConstant.VALIDATE_SETTING_BATTLE_NOWASTE: // 自动战斗开关-不浪费BP
                return MarzConstant.MARZSETTING_ON.equals(marzSettingEvt.getBattleNowaste());
            default:
                return false;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException
    {
        ContextUtil.setApplicationContext(applicationContext);
    }

    public static Log getLogger()
    {
        return logger;
    }

    public static void setLogger(Log logger)
    {
        MarzTask.logger = logger;
    }
}
