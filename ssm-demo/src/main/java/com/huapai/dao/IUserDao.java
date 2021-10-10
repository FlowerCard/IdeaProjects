package com.huapai.dao;

import com.huapai.bean.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/10.
 */
public interface IUserDao {
    
    public User selectUserByName(String username);
    
}
