package com.huapai.service;

import com.huapai.common.ResultVO;
import com.huapai.pojo.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */
public interface IUserService {

    /**
     * 登录
     * @param account   账号
     * @param password  密码
     * @return
     */
    public ResultVO login(String account,String password);

    /**
     * 注册
     * @param user 注册用户
     * @return
     */
    public ResultVO register(User user);

    /**
     * 检查用户
     * @param id 用户账号
     * @return
     */
    public ResultVO checkUser(String id);
    
    
}
