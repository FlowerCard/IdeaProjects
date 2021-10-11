package com.huapai.service.impl;

import com.huapai.dao.IUserDao;
import com.huapai.pojo.User;
import com.huapai.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/11.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    
    @Autowired
    private IUserDao userDao;
    
    /**
     * 查询所有用户
     *
     * @return 用户集合
     */
    @Override
    public List<User> queryUsers() {
        return userDao.selectAll();
    }

    /**
     * 通过用户ID查询
     *
     * @param id 用户ID
     * @return 用户对象
     */
    @Override
    public User queryById(Integer id) {
        return userDao.selectById(id);
    }

    /**
     * 添加用户
     *
     * @param user 用户对象
     * @return 受影响行数
     */
    @Override
    @Transactional
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
    @Transactional
    public Integer modifyUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 通过ID删除
     *
     * @param id 用户ID
     * @return 受影响行数
     */
    @Override
    @Transactional
    public Integer removeById(Integer id) {
        return userDao.deleteById(id);
    }

}
