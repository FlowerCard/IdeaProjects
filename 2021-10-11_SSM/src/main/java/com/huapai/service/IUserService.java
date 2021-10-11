package com.huapai.service;

import com.huapai.pojo.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/11.
 * User业务层接口
 */
public interface IUserService {

    /**
     * 查询所有用户
     * @return 用户集合
     */
    public List<User> queryUsers();

    /**
     * 通过用户ID查询
     * @param id 用户ID
     * @return 用户对象
     */
    public User queryById(Integer id);

    /**
     * 添加用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer addUser(User user);

    /**
     * 修改用户
     * @param user 用户对象
     * @return 受影响行数
     */
    public Integer modifyUser(User user);

    /**
     * 通过ID删除
     * @param id 用户ID
     * @return 受影响行数
     */
    public Integer removeById(Integer id);
    
}
