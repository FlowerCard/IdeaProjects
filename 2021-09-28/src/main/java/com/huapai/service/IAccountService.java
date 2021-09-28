package com.huapai.service;

import com.huapai.pojo.Account;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/28.
 */
public interface IAccountService {
    Integer addAccount(Account account);
    
    Integer modifyAccount(Account account);
    
    Integer removeAccount(Integer id);
    
    Account queryAccount(Account account);
}
