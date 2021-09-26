package com.huapai.service.impl;

import com.huapai.dao.IAccountDao;
import com.huapai.pojo.Account;
import com.huapai.service.IAccountService;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
public class AccountServiceImpl implements IAccountService {
    
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account queryAccountById(Integer id) {
        return accountDao.selectAccountById(id);
    }
}
