package com.huapai.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/3.
 */
public class User implements Serializable {

    private static final Long serialVersionUID = -1L;
    private Long id;
    private String useraccount;
    private String username;
    private String password;
    private String realname;
    private String idcode;
    private Date createTime;
    private Date modifiedTime;
    private Integer status;
    private Integer isdelete;

    public User() {
    }

    public User(Long id, String useraccount, String username, String password, String realname, String idcode, Date createTime, Date modifiedTime, Integer status, Integer isdelete) {
        this.id = id;
        this.useraccount = useraccount;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.idcode = idcode;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
        this.status = status;
        this.isdelete = isdelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", useraccount='" + useraccount + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", idcode='" + idcode + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", status=" + status +
                ", isdelete=" + isdelete +
                '}';
    }
}
