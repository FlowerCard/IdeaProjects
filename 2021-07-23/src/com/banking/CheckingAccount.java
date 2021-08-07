package com.banking;

public class CheckingAccount extends Account{
    private double overdraftProtection = 1000;

    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    public CheckingAccount(double init_balance, double overdraftProtection) {
        super(init_balance);
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public boolean withdraw(double amt) {
        if (super.getBalance() - amt < 0){

        }
        return super.withdraw(amt);
    }
}
