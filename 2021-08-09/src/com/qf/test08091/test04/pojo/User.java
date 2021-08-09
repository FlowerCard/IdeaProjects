package com.qf.test08091.test04.pojo;

/**
 * Created on 2021/8/9.
 *
 * @author HuaPai,
 * @email HuaPai@odcn.live
 */
public class User {
    private String userName;
    private Integer userMoney;

    public User() {
    }

    public User(String userName, Integer userMoney) {
        this.userName = userName;
        this.userMoney = userMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userMoney=" + userMoney +
                '}';
    }
}
