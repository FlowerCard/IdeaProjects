package com.huapai.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_account
 * @author 
 */
@Data
public class Account implements Serializable {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户邮箱
     */
    private String useraccount;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private Double balance;

    /**
     * 真实身份证
     */
    private String idcode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    /**
     * 0:未激活 1:已激活 2:注销 3:锁定 4:过期
     */
    private Integer status;

    /**
     * 0:未删除 1:已删除
     */
    private Integer isdelete;

    private static final long serialVersionUID = 1L;
}