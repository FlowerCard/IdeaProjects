package com.huapai.service;

import com.huapai.entity.ResultVO;
import com.huapai.entity.User;

import java.util.List;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/21.
 */
public interface IUserService {

    /**
     * 查询所有用户
     * @return 封装的用户数据
     */
    ResultVO<List<User>> queryAllUsers();

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 返回登录状态，消息，封装的用户信息
     */
    ResultVO<User> login(String username,String password);
    
}
