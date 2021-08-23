package com.qf.transfercase.pojo;

import java.io.Serializable;

/**
 * 账户实体类
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 401546097132676510L;

    private Long accountId;
    private String accountNum;
    private String accountName;
    private Double accountBalance;

    public Account() {
    }

    public Account(Long accountId, String accountNum, String accountName, Double accountBalance) {
        this.accountId = accountId;
        this.accountNum = accountNum;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNum='" + accountNum + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
