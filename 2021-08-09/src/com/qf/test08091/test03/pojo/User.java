package com.qf.test08091.test03.pojo;

import java.io.Serializable;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class User implements Serializable {
    /**
     * 生成一个序列化ID
     * 必修是 static final
     */
    public static final long serialVersionUID = -1L;

    private Integer userId;
    private String userName;
    private String passWord;

    //static 和 transient 是不能被序列化的
    public static int version;
    public transient String name;

    public User() {
    }

    public User(Integer userId, String userName, String passWord, String name) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public static int getVersion() {
        return version;
    }

    public static void setVersion(int version) {
        User.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
