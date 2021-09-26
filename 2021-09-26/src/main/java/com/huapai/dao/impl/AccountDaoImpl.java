package com.huapai.dao.impl;

import com.huapai.dao.IAccountDao;
import com.huapai.pojo.Account;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public Account selectAccountById(Integer id) {
        Account account = new Account();
        account.setId(id);
        account.setUsername("test01");
        account.setPassword("123123");
        account.setInfo("测试账户01");
        return account;
    }
}
