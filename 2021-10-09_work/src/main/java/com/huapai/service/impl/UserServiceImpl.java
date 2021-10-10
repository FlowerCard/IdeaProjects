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

    /**
     * 新增用户
     *
     * @param user 用户对象
     * @return 受影响行数
     */
    @Override
    public Integer addUser(User user) {
        return userDao.insertUser(user);
    }

    /**
     * 修改用户
     *
     * @param user 用户对象
     * @return 受影响行数
     */
    @Override
    public Integer modifyUser(User user) {
        return userDao.updateUserById(user);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 受影响行数
     */
    @Override
    public Integer removeUser(Integer id) {
        return userDao.deleteUserById(id);
    }
}
