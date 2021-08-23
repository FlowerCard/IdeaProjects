package com.work.service;


import com.work.pojo.Account;

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

    /**
     * 删除
     * @param targetNum 需要删除的用户名
     * @return  是否成功
     */
    public boolean deleteUser(String targetNum);

    /**
     * 增加
     * @param account 需要增加的用户对象
     * @return  是否成功
     */
    public boolean insertUser(Account account);

    /**
     * 存钱
     * @param num  账户
     * @param amount 金额
     * @return 是否成功
     */
    public boolean deposit(String num, Double amount);

    /**
     * 更新
     * @param num   账户
     * @param name  名字
     * @return  是否成功
     */
    public boolean updateUser(String num ,String name);

}
