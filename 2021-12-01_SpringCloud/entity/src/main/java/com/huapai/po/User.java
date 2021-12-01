package com.huapai.po;

import java.io.Serializable;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/1.
 */
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 信息
     */
    private String info;

    /**
     * 角色
     */
    private String role;

    /**
     * 身份验证
     */
    private String auth;

    private static final long serialVersionUID = 1L;
}