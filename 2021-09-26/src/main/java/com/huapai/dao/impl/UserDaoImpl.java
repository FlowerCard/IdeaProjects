package com.huapai.dao.impl;

import com.huapai.dao.IUserDao;
import com.huapai.pojo.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/26.
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User selectUserById(Integer id) {
        User user = new User();
        user.setId(1001);
        user.setUsername("阿拉斯加");
        user.setPassword("Alaska");
        user.setInfo("来自阿拉斯加");
        return user;
    }
}
