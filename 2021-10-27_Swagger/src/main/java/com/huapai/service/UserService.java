package com.huapai.service;

import com.huapai.entity.ResultVO;
import com.huapai.entity.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/27.
 */
public interface UserService {

    /**
     * 查询所有用户对象
     * @return 用户结果集
     */
    List<User> queryAll();

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 封装User的ResultVO
     */
    ResultVO queryByUsername(String username);

    /**
     * 通过ID查询用户
     * @param id 用户id
     * @return 封装User的ResultVO
     */
    ResultVO queryById(Integer id);

    /**
     * 添加用户
     * @param user 用户对象
     * @return 是否成功
     */
    Boolean addUser(User user);

    /**
     * 修改User
     * @param user User对象
     * @return 是否成功
     */
    Boolean modifyUser(User user);

    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否成功
     */
    Boolean removeUser(Integer id);
    
}
