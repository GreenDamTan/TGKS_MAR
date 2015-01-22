package com.moemao.tgks.mar.invite.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.moemao.tgks.mar.account.entity.AccountEvt;
import com.moemao.tgks.mar.account.entity.AccountReq;
import com.moemao.tgks.mar.account.service.AccountService;
import com.moemao.tgks.mar.execute.KrsmaRequest;
import com.moemao.tgks.mar.invite.service.InviteService;
import com.moemao.tgks.mar.tool.MarConstant;

public class InviteServiceImpl implements InviteService
{
    private KrsmaRequest request = KrsmaRequest.getInstance();

    private AccountService mar_accountService;
    
    /**
     * 返回最后一个招待的ID 给自动刷初始流程提供5个石头
     */
    public String invite(String inviteCode)
    {
        String inviteName = "Kirito";
        String inviteChara = "3";
        String[] result = new String[2];
        String sessionId;
        // 返回最后一个招待的ID
        String returnCode = "";
        // 招待个数
        int num = 10;
        JSONObject json= null;

        List<String> inviteSessonIdList = new ArrayList<String>();
        
        try
        {
            for (int i = 1; i <= num; i++)
            {
                result[0] = request.regist();
                
                // 从regist的result中解析出sessonId
                json= JSONObject.fromObject(result[0]);
                sessionId = (String) json.get("sess_key");
                inviteSessonIdList.add(sessionId.replace("=", ""));
            }
            
            for (String sid : inviteSessonIdList)
            {
                request.connect(sid);
            }
            
            Thread.sleep(5000);
            
            int index = 0;
            for (String sid : inviteSessonIdList)
            {
                index++;
                request.userCreate(sid, inviteName, inviteChara);
                result = request.homeShow(sid);
                sid = result[0];
                request.inviteCodeEnter(sid, inviteCode);
                System.out.println("第" + index + "个招待已经完成！");// 临时打印
                
                if (index == num)
                {
                    // 记录最后一个号的招待ID
                    returnCode = result[1].split("inviteid\":\"")[1].substring(0, 9);
                }
            }
        }
        catch (Exception e)
        {
            
        }
        
        return returnCode;
    }
    
    public void invite2(String inviteCode)
    {
        String[] result = new String[2];
        String sid;
        JSONObject json= null;
        
        AccountReq accountReq = new AccountReq();
        accountReq.setStatus(MarConstant.ACCOUNT_STATUS_4);
        accountReq.setSortSql(" t.ID Limit 0, 10");
        
        // 查询出10个可以用来刷招待的号
        List<AccountEvt> accountList = this.mar_accountService.queryAccount(accountReq);

        try
        {
            for (AccountEvt accountEvt : accountList)
            {
                // 1 登录
                result[0] = request.login2(accountEvt.getUuid(), accountEvt.getHashToken());
                json= JSONObject.fromObject(result[0]);
                sid = json.getString("sess_key").replace("=", "");
                result = request.connect(sid);
                sid = result[0];
                
                // 2 填招待ID
                request.inviteCodeEnter(sid, inviteCode);
                
                // 刷完招待更新一下账号状态
                accountEvt.setStatus(MarConstant.ACCOUNT_STATUS_5);
                this.mar_accountService.updateAccount(accountEvt);
            }
        }
        catch (Exception e)
        {
            
        }
    }

    public KrsmaRequest getKrsmaRequest()
    {
        return request;
    }

    public void setKrsmaRequest(KrsmaRequest request)
    {
        this.request = request;
    }

    public AccountService getMar_accountService()
    {
        return mar_accountService;
    }

    public void setMar_accountService(AccountService mar_accountService)
    {
        this.mar_accountService = mar_accountService;
    }
}
