package com.qf.test0823.dao;

import com.qf.test0823.pojo.Account;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public interface IAccountDao {

    /**
     * 通过名字查询
     * @param accountName   账户名
     * @return              返回受影响行数
     */
    public int findByName(String accountName);

    /**
     * 更新账户
     * @param account   需要更新的账户
     * @return          返回受影响行数
     */
    public int update(Account account);

}
