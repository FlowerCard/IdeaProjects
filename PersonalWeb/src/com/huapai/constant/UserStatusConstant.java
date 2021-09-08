package com.huapai.constant;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/8.
 */
public interface UserStatusConstant {

    /**
     * 未激活
     */
    Integer INACTIVE_USERS = 0;

    /**
     * 注销
     */
    Integer LOGGED_OUT_USERS = 2;

    /**
     * 锁定
     */
    Integer LOCKS_PER_USER = 3;

    /**
     * 过期
     */
    Integer EXPIRED_USER = 4;



}
