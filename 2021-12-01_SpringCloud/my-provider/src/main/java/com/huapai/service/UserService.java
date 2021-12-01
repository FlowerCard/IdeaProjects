package com.huapai.service;

import com.huapai.po.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
public interface UserService {
    
    User getUserByUsername(String username);
    
    User getUserById(Integer id);
    
    Boolean modifyUser(User user);
    
    Boolean addUser(User user);
    
    Boolean removeUser(Integer id);
    
}
