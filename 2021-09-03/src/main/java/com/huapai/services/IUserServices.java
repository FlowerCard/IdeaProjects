package com.huapai.services;

import com.huapai.common.ResultVO;
import com.huapai.pojo.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
 */
public interface IUserServices {

    /**
     * 登录
     * @param account   账号
     * @param password  密码
     * @return
     */
    public ResultVO login(String account,String password);

    /**
     * 注册
     * @param user 用户
     * @return 受影响行数
     */
    public Boolean register(User user);
    
}
