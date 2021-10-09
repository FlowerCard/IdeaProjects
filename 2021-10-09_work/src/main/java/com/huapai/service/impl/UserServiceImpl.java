package com.huapai.service.impl;

import com.huapai.dao.IUserDao;
import com.huapai.pojo.User;
import com.huapai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/9.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao userDao;

    /**
     * 搜索所有用户
     *
     * @return 用户集合
     */
    @Override
    public List<User> searchAllUsers() {
        return userDao.selectAllUsers();
    }

    /**
     * 通过用户ID查询
     *
     * @param id 用户ID
     * @return 用户对象
     */
    @Override
    public User searchUserById(Integer id) {
        return userDao.selectUserById(id);
    }
}
