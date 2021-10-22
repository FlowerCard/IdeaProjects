package com.huapai.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/22.
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
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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