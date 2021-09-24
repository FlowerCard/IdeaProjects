package com.huapai.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/24.
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 42L;

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
