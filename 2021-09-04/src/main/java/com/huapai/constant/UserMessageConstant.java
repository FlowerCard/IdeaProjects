package com.huapai.constant;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/4.
 */
public interface UserMessageConstant {

    /**
     * 未激活
     */
    String INACTIVE_USER = "用户未激活，请激活";

    /**
     * 注销
     */
    String LOGGED_OUT_USER = "用户已注销，如需继续使用，请联系管理员恢复";

    /**
     * 锁定
     */
    String LOCKS_PRE_USER = "用户已锁定，请联系管理员";

    /**
     * 过期
     */
    String EXPIRED_USER = "用户已过期，请联系管理员";

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
    String REGISTER_FAIL = "注册失败";

    /**
     * 注册成功
     */
    String RESGISTER_SUCCESS = "注册成功";

}
