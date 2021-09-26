package com.huapai.dao;

import com.huapai.pojo.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
public interface IUserDao {
    
    User selectUserById(Integer id); 
    
}
