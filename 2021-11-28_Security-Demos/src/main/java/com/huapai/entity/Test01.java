package com.huapai.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/11/28.
 */
@Data
public class Test01 implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 账户
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 管理员标记 0:普通用户 1:管理员
     */
    private Boolean isAdmin;

    private static final long serialVersionUID = 1L;
}