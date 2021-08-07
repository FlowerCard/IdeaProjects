package com.qf.test07271.test06;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;

    public Account() {
    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
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

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return this.annualInterestRate / 12;
    }

    /**
     * 取款
     * @param amount    取款金额
     */
    public void withdraw(double amount){
        if (this.balance - amount < 0){
            System.out.println("余额不足");
            System.out.println("您的账户余额为：" + this.balance);
        }else {
            this.balance -= amount;
            System.out.println("您的账户余额为：" + this.balance);
        }
    }

    public void deposit(double amount){
        this.balance += amount;
        System.out.println("您的账户余额为：" + this.balance);
        System.out.println("月利率为：" + this.getMonthlyInterest());
    }

}
