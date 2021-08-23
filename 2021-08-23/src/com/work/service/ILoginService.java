package com.work.service;

import com.work.pojo.User;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public interface ILoginService {

    /**
     * 登录
     * @param useraccount   账号
     * @param password      密码
     * @return  是否成功
     */
    public boolean login(String useraccount,String password);

    /**
     * 注册
     * @param user 对象
     * @return  是否成功
     */
    public boolean signUp(User user);

}
