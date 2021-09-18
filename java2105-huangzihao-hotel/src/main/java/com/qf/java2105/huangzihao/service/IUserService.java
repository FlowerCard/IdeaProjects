package com.qf.java2105.huangzihao.service;

import com.qf.java2105.huangzihao.entity.ResultVO;
import com.qf.java2105.huangzihao.pojo.User;

import java.util.List;

/**
 * 用户业务层
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/14.
 */
public interface IUserService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public ResultVO<User> login(String username,String password);

    /**
     * 搜索用户
     * @param username 用户名
     * @return
     */
    public ResultVO<List<User>> search(String username);

    /**
     * 用户ID
     * @param userId 用户ID
     * @return
     */
    public ResultVO<User> updateui(Integer userId);

    /**
     * 更新用户
     * @param user 用户对象
     * @return
     */
    public ResultVO<String> update(User user);

    /**
     * 删除用户
     * @param userId 
     * @return
     */
    public ResultVO<String> deleteById(Integer userId);

    /**
     * 注册
     * @param user 用户
     * @return
     */
    public ResultVO<String> register(User user);

    /**
     * 用户名是否存在
     * @param username 用户名
     * @return
     */
    public ResultVO<String> exitisName(String username);
    
}
