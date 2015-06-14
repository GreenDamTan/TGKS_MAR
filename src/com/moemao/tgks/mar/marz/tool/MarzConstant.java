package com.moemao.tgks.mar.marz.tool;

public class MarzConstant
{
    public static final String LOG_SYSTEM_INFO = "[MARZ_INFO] ";

    public static final int SUCCESS = 0;
    
    public static final int FAILED = -1;
    
    public static final int RES_CODE_SUCCESS_0 = 0;

    /**
     * 登录错误码：-5 服务器维护中
     */
    public static final int RES_CODE_ERROR_M5 = -5;
    
    /**
     * 登录错误码：-7 账号重新引继过
     */
    public static final int RES_CODE_ERROR_M7 = -7;
    
    /**
     * 登录错误码：-8 客户端已更新 服务器需要同步更新
     */
    public static final int RES_CODE_ERROR_M8 = -8;
    
    /**
     * 登录错误码：-607 招待已刷满
     */
    public static final int RES_CODE_ERROR_M607 = -607;
    
    public static final String OVER = "over";
    
    public static final int SLEEPTIME_BATTLE_SOLO = 60000;
    
    public static final String JSON_TAG_SID = "sid";
    public static final String JSON_TAG_RESCODE = "res_code";
    public static final String JSON_TAG_HOMWSHOW = "homeShow";
    public static final String JSON_TAG_EXPLORESTART= "exploreStart";
    public static final String JSON_TAG_EXPLOREEND= "exploreEnd";
    public static final String JSON_TAG_CARDSHOW = "cardShow";
    public static final String JSON_TAG_CARDFUSION = "cardFusion";
    public static final String JSON_TAG_CARDSELL = "cardSell";
    public static final String JSON_TAG_PRESENTBOXMULTIRECV = "presentBoxMultiRecv";
    public static final String JSON_TAG_TEAMBATTLESOLOSHOW = "teamBattleSoloShow";
    public static final String JSON_TAG_TEAMBATTLESOLOSTART = "teamBattleSoloStart";
    public static final String JSON_TAG_TEAMBATTLESOLOEND = "teamBattleSoloEnd";
    public static final String JSON_TAG_PVPSHOW = "pvpShow";
    public static final String JSON_TAG_PVPSTART = "pvpStart";
    public static final String JSON_TAG_PVPEND = "pvpEnd";
    public static final String JSON_TAG_MISSIONSHOW = "missionShow";
    public static final String JSON_TAG_MISSIONREWARD = "missionReward";
    
    public static final int VALIDATE_SETTING_EXPLORE = 1;
    public static final int VALIDATE_SETTING_CARDSELL = 2;
    public static final int VALIDATE_SETTING_CARDSELL_COMMON = 3;
    public static final int VALIDATE_SETTING_CHIARIFUSION = 4;
    public static final int VALIDATE_SETTING_BATTLE = 5;
    public static final int VALIDATE_SETTING_BATTLE_NOWASTE = 6;
    public static final int VALIDATE_SETTING_BATTLE_NOWASTE_BOSSID = 7;
    public static final int VALIDATE_SETTING_BATTLE_GET_STONE = 8;
    public static final int VALIDATE_SETTING_PVP = 9;
    public static final int VALIDATE_SETTING_FAMEFUSION = 10;
    
    /**
     * MARZACCOUNT 账号类型 0 IOS
     */
    public static final String MARZ_ACCOUNT_TYPE_0 = "0";
    /**
     * MARZACCOUNT 账号类型 1 Android
     */
    public static final String MARZ_ACCOUNT_TYPE_1 = "1";
    
    /**
     * MARZACCOUNT 登录状态 0 离线
     */
    public static final String MARZ_ACCOUNT_STATUS_0 = "0";
    /**
     * MARZACCOUNT 登录状态 1 在线
     */
    public static final String MARZ_ACCOUNT_STATUS_1 = "1";

    /**
     * MARZACCOUNT VIP 0 试用
     */
    public static final String MARZ_ACCOUNT_VIP_0 = "0";
    /**
     * MARZACCOUNT VIP 1 普通
     */
    public static final String MARZ_ACCOUNT_VIP_1 = "1";
    /**
     * MARZACCOUNT VIP 2 白金
     */
    public static final String MARZ_ACCOUNT_VIP_2 = "2";
    /**
     * MARZACCOUNT VIP 3 钻石
     */
    public static final String MARZ_ACCOUNT_VIP_3 = "3";

    /**
     * MARZLOG TYPE 0 系统
     */
    public static final String MARZ_LOG_TYPE_0 = "0";
    /**
     * MARZLOG TYPE 1 战斗
     */
    public static final String MARZ_LOG_TYPE_1 = "1";
    /**
     * MARZLOG TYPE 2 探索
     */
    public static final String MARZ_LOG_TYPE_2 = "2";
    /**
     * MARZLOG TYPE 3 道具购买/使用
     */
    public static final String MARZ_LOG_TYPE_3 = "3";
    /**
     * MARZLOG TYPE 4 合成
     */
    public static final String MARZ_LOG_TYPE_4 = "4";
    /**
     * MARZLOG TYPE 5 出售
     */
    public static final String MARZ_LOG_TYPE_5 = "5";
    /**
     * MARZLOG TYPE 6 PVP
     */
    public static final String MARZ_LOG_TYPE_6 = "6";
    /**
     * MARZLOG TYPE 9 点卡充值
     */
    public static final String MARZ_LOG_TYPE_9 = "9";
    
    public static final String MARZCARD_STATUS_0 = "0";
    
    public static final String MARZCARD_STATUS_1 = "1";
    
    public static final String MARZCARD_TYPE_0 = "0";
    
    public static final String MARZCARD_TYPE_1 = "1";
    
    public static final String MARZCARD_TYPE_2 = "2";
    
    public static final String MARZCARD_TYPE_3 = "3";
    
    public static final String MARZSETTING_Off = "0";

    public static final String MARZSETTING_ON = "1";
    
    /**
     * MARZ设置 0 开关
     */
    public static final String MARZSETTING_TYPE_0 = "0";
    
    /**
     * MARZ设置 1 参数
     */
    public static final String MARZSETTING_TYPE_1 = "1";
    
    /**
     * MARZ副本状态 0 未战斗
     */
    public static final String MARZMAP_STATE_0 = "0";
    
    /**
     * MARZ副本状态 1 已战斗未通过
     */
    public static final String MARZMAP_STATE_1 = "1";
    
    /**
     * MARZ副本状态 2 已通过
     */
    public static final String MARZMAP_STATE_2 = "2";
}
