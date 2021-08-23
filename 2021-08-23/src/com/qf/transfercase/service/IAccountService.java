package com.qf.transfercase.service;

/**
 * 账户业务接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public interface IAccountService {

    /**
     * 转账
     * @param sourceUser    源用户
     * @param targetUser    目标用户
     * @param amount        金额
     * @return              是否成功
     */
    public boolean transfer(String sourceUser,String targetUser,Double amount);

}
