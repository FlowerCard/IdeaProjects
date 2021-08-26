package com.huapai.service;

import com.huapai.pojo.Account;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/24.
 */
public interface IAccountService {

    /**
     * 转账
     * @param sourceUserNum 源账户
     * @param targetUserNum 目标账户
     * @param amount 金额
     * @return 是否成功
     */
    public boolean transfer(String sourceUserNum,String targetUserNum,Double amount);

    /**
     * 存款
     * @param accountNum 账户Num
     * @param amount 金额
     * @return 是否成功
     */
    public boolean deposit(String accountNum,Double amount);

    /**
     * 取款
     * @param accountNum 账户Num
     * @param amount 金额
     * @return 是否成功
     */
    public boolean withdrawal(String accountNum,Double amount);

    /**
     * 创建用户
     * @param account 用户对象
     * @return 是否成功
     */
    public boolean createUser(Account account);

    /**
     * 删除用户
     * @param accountNum 用户Num
     * @return 是否成功
     */
    public boolean deleteUser(String accountNum);

}
