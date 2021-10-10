package com.huapai.service.impl;

import com.huapai.bean.User;
import com.huapai.dao.IUserDao;
import com.huapai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/10.
 */
@Service
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao userDao;
    
    @Override
    @Transactional
    public User checkLogin(String username, String password) {
        User user = userDao.selectUserByName(username);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
