package com.huapai.service.impl;

import com.huapai.dao.UserDao;
import com.huapai.entity.User;
import com.huapai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public List<User> queryAll() {
        return userDao.selectAll();
    }

    @Override
    public User queryById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public void addUser(User user) {
        int row = userDao.insertSelective(user);
    }

    @Override
    public void modifyUser(User user) {
        int row = userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public void removeUser(Integer id) {
        int row = userDao.deleteByPrimaryKey(id);
    }
}
