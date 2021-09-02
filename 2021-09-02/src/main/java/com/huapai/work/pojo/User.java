package com.huapai.work.pojo;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/2.
 */
public class User {

    private Integer id;
    private String useraccount;
    private String username;
    private String password;
    private Double balance;

    public User() {
    }

    public User(Integer id, String useraccount, String username, String password, Double balance) {
        this.id = id;
        this.useraccount = useraccount;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "User{" +
                "id=" + id +
                ", useraccount='" + useraccount + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
