package com.huapai.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/15.
 */
@Data
/**
 * 用来说明实体类的作用
 */
@ApiModel(value = "User对象",description = "封装接口给前端的数据")
public class User implements Serializable {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户自动生成ID",dataType = "int")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户登录名",dataType = "string")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "用户密码",dataType = "string")
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "用户邮箱",dataType = "string")
    private String email;

    /**
     * 信息
     */
    @ApiModelProperty(value = "用户介绍",dataType = "string")
    private String info;

    private static final long serialVersionUID = 1L;
}