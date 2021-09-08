package com.huapai.constant;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */
public interface UserMessageConstant {

    //0:未激活 1:已激活 2:注销 3:锁定 4:过期
    
    /**
     * 未激活
     */
    String INACTIVE_USER = "用户未激活，请及时激活";

    /**
     * 注销
     */
    String LOGGED_OUT_USER = "用户已注销，如需继续使用，请联系管理员";

    /**
     * 锁定
     */
    String LOCKS_PRE_USER = "用户已锁定，请联系管理员";

    /**
     * 过期
     */
    String EXPIRED_USER = "用户已过期，请重新激活";

    /**
     * 未知用户
     */
    String UNKNOWN_USER = "用户未注册，请注册";

    /**
     * 删除
     */
    String MARK_DELETED_USER = "用户不存在";

    /**
     * 登录失败
     */
    String LOGIN_FAIL = "用户名或密码错误";

    /**
     * 登录成功
     */
    String LOGIN_SUCCES = "登录成功";

    /**
     * 注册失败
     */
    String REGISTER_FAIL = "用户已存在";

}
