package com.huapai.service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/29.
 */
public interface IAccountService {

    /**
     * 转账
     * @param fromName  转出账户
     * @param toName    转入账户
     * @param amount    金额
     * @return
     */
    Integer transfer(String fromName,String toName,Double amount);
    
}
