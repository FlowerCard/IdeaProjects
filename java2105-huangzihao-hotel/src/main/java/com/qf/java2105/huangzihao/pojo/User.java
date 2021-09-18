package com.qf.java2105.huangzihao.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/11.
 */
public class User implements Serializable {
    
    private static final long serialVersionUID = -19L;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 是否管理员
     */
    private Integer admin;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date userCreateTime;
    /**
     * 修改时间
     */
    private Date userModifieTime;
    /**
     * 是否删除
     */
    private Integer deleted;
    /**
     * 是否会员
     */
    private Integer member;
    /**
     * 余额
     */
    private BigDecimal balance;

    public User() {
    }

    public User(Long userId, String username, String password, String nickname, Integer admin, String phone, Integer gender, Integer status, Date userCreateTime, Date userModifieTime, Integer deleted, Integer member, BigDecimal balance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.admin = admin;
        this.phone = phone;
        this.gender = gender;
        this.status = status;
        this.userCreateTime = userCreateTime;
        this.userModifieTime = userModifieTime;
        this.deleted = deleted;
        this.member = member;
        this.balance = balance;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserModifieTime() {
        return userModifieTime;
    }

    public void setUserModifieTime(Date userModifieTime) {
        this.userModifieTime = userModifieTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
