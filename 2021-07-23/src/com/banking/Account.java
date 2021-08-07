package com.banking;

public class Account {

    protected double balance;
    private boolean flag;

    public Account(double init_balance){
        this.balance = init_balance;
        System.out.println(this.balance);
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt){
        this.balance += amt;
        System.out.println(amt + ":true");
        return true;
    }

    public boolean withdraw(double amt){
        if (this.balance - amt < 0){
            this.flag = false;
            System.out.println(amt + ":" + this.flag);
        }else {
            this.balance -= amt;
            this.flag = true;
            System.out.println(amt + ":" + this.flag);
        }
        return flag;
    }

    public void display(){
        if (this.flag){
            System.out.println("交易成功");
        }else {
            System.out.println("交易失败");
        }
    }

}
