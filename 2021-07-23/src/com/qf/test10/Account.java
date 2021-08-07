package com.qf.test10;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;

    /**
     * 构造初始账户
     * @param id                    账号
     * @param balance               余额
     * @param annuallnterestRate    年利率
     */
    public Account(int id,double balance,double annuallnterestRate){
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * 取款
     * @param amount    取款金额
     */
    public void withdraw(double amount){
        if (this.balance - amount < 0){
            System.out.println("余额不足");
        }else {
            this.balance -= amount;
            System.out.println("余额为：" + this.balance);
        }
    }

    /**
     * 存款
     * @param amount    存款金额
     */
    public void deposit(double amount){
        this.balance += amount;
        System.out.println("余额为：" + this.balance);
    }

}
