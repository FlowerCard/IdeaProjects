package com.huapai.service;

import com.huapai.entity.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/15.
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return 用户集合
     */
    List<User> queryAll();

    /**
     * 根据ID查询
     * @param id 用户id
     * @return 用户对象
     */
    User queryById(Integer id);

    /**
     * 增加用户
     * @param user 用户对象
     */
    void addUser(User user);

    /**
     * 修改用户
     * @param user 用户对象
     */
    void modifyUser(User user);

    /**
     * 删除用户
     * @param id 用户id
     */
    void removeUser(Integer id);
    
}
