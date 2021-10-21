package com.huapai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/10/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User对象",description = "封装用户数据")
public class User implements Serializable {
    
    private static final long serialVersionUID = 42L;
    
    @ApiModelProperty(value = "用户ID，自动生成",dataType = "int")
    private Integer id;
    @ApiModelProperty(value = "用户名，唯一不可重复",dataType = "string")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "密码",dataType = "string")
    private String password;
    @ApiModelProperty(value = "邮箱",dataType = "string")
    private String email;
    @ApiModelProperty(value = "用户介绍",dataType = "string")
    private String info;
    @ApiModelProperty(value = "用户角色",dataType = "string")
    private String role;
    @ApiModelProperty(value = "用户权限",dataType = "string")
    private String auth;
    
}
