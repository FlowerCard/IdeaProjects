package com.huapai.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * Created on 2021/10/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public PageInfo<List<User>> queryAll(Integer page,Integer limit) {
        PageHelper.startPage(page, limit);
        List<User> userList = userDao.selectAll();
        PageInfo pageInfo = new PageInfo(userList);
        if (userList.size() == 0) {
            return null;
        } else {
            return pageInfo;
        }
    }

    @Override
    public User queryById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public Boolean modifyUser(User user) {
        int row = userDao.updateByPrimaryKeySelective(user);
        return row != 0;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public Boolean addUser(User user) {
        User existUser = userDao.selectByUserName(user.getUsername());
        if (existUser != null) {
            return false;
        }
        int row = userDao.insertSelective(user);
        return row != 0;
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public Boolean removeUser(Integer id) {
        int row = userDao.deleteByPrimaryKey(id);
        return row != 0;
    }

}
