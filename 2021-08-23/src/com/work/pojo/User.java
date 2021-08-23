package com.work.pojo;

import java.io.Serializable;

/**
 * 登录实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 4978664761204654648L;
    private Long id;
    private String useraccount;
    private String username;
    private String password;
    private Double balance;

    public User() {
    }

    public User(String useraccount, String username, String password, Double balance) {
        this.useraccount = useraccount;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public User(Long id, String useraccount, String username, String password, Double balance) {
        this.id = id;
        this.useraccount = useraccount;
        this.username = username;
        this.password = password;
        this.balance = balance;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", useraccount='" + useraccount + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
