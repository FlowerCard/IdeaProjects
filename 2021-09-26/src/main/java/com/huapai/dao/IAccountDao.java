package com.huapai.dao;

import com.huapai.pojo.Account;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
public interface IAccountDao {
    
    Account selectAccountById(Integer id);
    
}
