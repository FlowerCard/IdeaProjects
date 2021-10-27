package com.huapai.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/27.
 */
@Data
@ApiModel(
        value = "用户实体",
        description = "对应数据库的用户表"
)
public class User implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID，自动生成无需填入", dataType = "int")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名，唯一索引，不可重复", dataType = "string")
    private String username;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", dataType = "string")
    private String nickname;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", dataType = "string")
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", dataType = "string")
    private String email;

    /**
     * 信息
     */
    @ApiModelProperty(value = "信息", dataType = "string")
    private String info;

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色，默认：employee", dataType = "string")
    private String role;

    /**
     * 身份验证
     */
    @ApiModelProperty(value = "身份验证，默认：user_query", dataType = "string")
    private String auth;

    private static final long serialVersionUID = 1L;
}