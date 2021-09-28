package com.huapai.service.impl;

import com.huapai.pojo.Account;
import com.huapai.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Override
    public Integer addAccount(Account account) {
        System.out.println("AccountServiceImpl =====》 addAccount");
//        System.out.println(10/0);
        return null;
    }

    @Override
    public Integer modifyAccount(Account account) {
        return null;
    }

    @Override
    public Integer removeAccount(Integer id) {
        System.out.println("AccountServiceImpl =====》 removeAccount");
        return null;
    }

    @Override
    public Account queryAccount(Account account) {
        return null;
    }
}
