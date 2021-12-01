package com.huapai.service.impl;

import com.huapai.dao.UserDao;
import com.huapai.po.User;
import com.huapai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public User getUserByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public Boolean modifyUser(User user) {
        int row = userDao.updateByPrimaryKeySelective(user);
        return row != 0;
    }

    @Override
    public Boolean addUser(User user) {
        int row = userDao.insertSelective(user);
        return row != 0;
    }

    @Override
    public Boolean removeUser(Integer id) {
        int row = userDao.deleteByPrimaryKey(id);
        return row != 0;
    }
}
