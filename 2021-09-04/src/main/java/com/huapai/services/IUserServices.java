package com.huapai.services;

import com.huapai.common.ResultVO;
import com.huapai.pojo.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
public interface IUserServices {

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return
     */
    public ResultVO login(String account, String password);

    /**
     * 注册
     * @param user 用户
     * @return
     */
    public Boolean resgister(User user);

    /**
     * 用户列表
     * @return
     */
    public ResultVO userList();
    
}
