package com.huapai.service;

import com.huapai.entity.ResultVO;
import com.huapai.entity.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/12.
 * 用户业务层接口
 */
public interface IUserService {

    /**
     * 查询所有
     * @return 用户集合
     */
    public List<User> queryAll();

    /**
     * 用户是否存在
     * @param username 用户名
     * @return 是否存在
     */
    public Boolean existUser(String username);

    /**
     * 通过id查询
     * @param id 用户id
     * @return 用户对象
     */
    public User queryById(Integer id);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    public ResultVO login(String username,String password);

    /**
     * 注册
     * @param user 用户对象
     * @return 结构
     */
    public Boolean register(User user);

    /**
     * 修改用户
     * @param user 用户对象
     * @return 是否成功
     */
    public Boolean modifyUser(User user);

    /**
     * 根据用户ID删除
     * @param id 用户ID
     * @return 是否成功
     */
    public Boolean removeUser(Integer id);
    
    
}
