package com.huapai.services;

import com.huapai.common.ResultVO;

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
    
}
