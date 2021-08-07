package com.qf.test07271.test06;

public class CheckAccount extends Account{

    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount){
        if (amount < super.getBalance()){
            super.setBalance(super.getBalance() - amount);
            System.out.println("您账户余额为：" + super.getBalance());
        }else if(amount > super.getBalance()){
            double temp = amount - super.getBalance();
            if (temp < this.overdraft){
                super.setBalance(0);
                this.overdraft -= temp;
                System.out.println("您账户余额为：" + super.getBalance());
                System.out.println("您目前剩余可透支额度为：" + this.overdraft);
            }else {
                System.out.println("可透支余额不足");
                System.out.println("您目前剩余可透支额度为：" + this.overdraft);
            }
        }
    }
}
