package com.huapai.service;

import com.huapai.bean.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/10.
 */
public interface IUserService {
    
    public User checkLogin(String username,String password);
    
}
