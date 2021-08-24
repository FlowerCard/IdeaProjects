package com.huapai.pojo;

import java.io.Serializable;

/**
 * 账户实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/24.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;
    private String accountNum;
    private String accountName;
    private String balance;

    public Account() {
    }

    public Account(String accountNum, String accountName, String balance) {
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Account(Long id, String accountNum, String accountName, String balance) {
        this.id = id;
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNum='" + accountNum + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
