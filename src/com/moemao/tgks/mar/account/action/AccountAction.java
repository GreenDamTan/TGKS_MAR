package com.moemao.tgks.mar.account.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.moemao.tgks.common.core.action.TGKSAction;
import com.moemao.tgks.common.tool.CommonConstant;
import com.moemao.tgks.common.tool.CommonUtil;
import com.moemao.tgks.common.tool.StringUtil;
import com.moemao.tgks.mar.account.entity.AccountEvt;
import com.moemao.tgks.mar.account.entity.AccountReq;
import com.moemao.tgks.mar.account.service.AccountService;

public class AccountAction extends TGKSAction
{

    /** 
     * @Fields serialVersionUID
     */ 
    private static final long serialVersionUID = -4600107108074187231L;

    private static Log logger = LogFactory.getLog(AccountAction.class);
    
    /**
     * ﻿Account业务接口
     */
    private AccountService mar_accountService;
    
    /**
     * 查询结果集
     */
    private List<AccountEvt> list;
    
    /**
     * ﻿AccountEvt对象
     */
    private AccountEvt accountEvt;
    
    /**
     * ﻿Account查询条件封装对象（自动生成代码后需要new对象）
     */
    private AccountReq accountReq = new AccountReq();
    
    public String accountManager()
    {
    return SUCCESS;
    }
    
    public String queryAccount()
    {
    list = mar_accountService.queryAccount(accountReq);
    return SUCCESS;
    }
    
    public String editAccountPage()
    {
    String id = this.getRequest().getParameter("id");
    if (!CommonUtil.isEmpty(id))
    {
    accountEvt = mar_accountService.queryAccountById(id);
    }
    return SUCCESS;
    }
    
    public String editAccount()
    {
    CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "AccountAction.updateAccount");
    int result = 0;
    if (CommonUtil.isEmpty(accountEvt.getId()))
    {
    result = mar_accountService.addAccount(accountEvt);
    CommonUtil.systemLog("mar/editAccount.action", CommonConstant.SYSTEMLOG_TYPE_1, result == 0 ? CommonConstant.FAILD : CommonConstant.SUCCESS, String.format("新增accountEvt\n%S", accountEvt.toString()));
    }
    else
    {
    result = mar_accountService.updateAccount(accountEvt);
    CommonUtil.systemLog("mar/editAccount.action", CommonConstant.SYSTEMLOG_TYPE_2, result == 0 ? CommonConstant.FAILD : CommonConstant.SUCCESS, String.format("修改accountEvt\n%S", accountEvt.toString()));
    }
    CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
    CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "AccountAction.updateAccount");
    return SUCCESS;
    }
    
    public String deleteAccount()
    {
    CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_IN, "AccountAction.deleteAccount");
    String ids = this.getRequest().getParameter("ids");
    int result = mar_accountService.deleteAccount(CommonUtil.stringToList(ids));
    CommonUtil.systemLog("mar/deleteAccount.action", CommonConstant.SYSTEMLOG_TYPE_3, result == 0 ? CommonConstant.FAILD : CommonConstant.SUCCESS, String.format("删除accountEvt\nID:%S", ids));
    CommonUtil.infoLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_EXECUTE_NUMS, StringUtil.toBeString(result));
    CommonUtil.debugLog(logger, CommonConstant.SYSTEM_INFO_LOG_METHOD_OUT, "AccountAction.deleteAccount");
    return SUCCESS;
    }
    
    /**
     * @return 返回 mar_accountService
     */
    public AccountService getMar_accountService()
    {
        return mar_accountService;
    }
    
    /**
     * @param 对mar_accountService进行赋值
     */
    public void setMar_accountService(AccountService mar_accountService)
    {
        this.mar_accountService = mar_accountService;
    }
    
    /**
     * @return 返回 list
     */
    public List<AccountEvt> getList()
    {
        return list;
    }
    
    /**
     * @param 对list进行赋值
     */
    public void setList(List<AccountEvt> list)
    {
        this.list = list;
    }
    
    /**
     * @return 返回 accountEvt
     */
    public AccountEvt getAccountEvt()
    {
        return accountEvt;
    }
    
    /**
     * @param 对accountEvt进行赋值
     */
    public void setAccountEvt(AccountEvt accountEvt)
    {
        this.accountEvt = accountEvt;
    }
    
    /**
     * @return 返回 accountReq
     */
    public AccountReq getAccountReq()
    {
        return accountReq;
    }
    
    /**
     * @param 对accountReq进行赋值
     */
    public void setAccountReq(AccountReq accountReq)
    {
        this.accountReq = accountReq;
    }

}