package com.qf.test10;

import java.text.DecimalFormat;

public class Test10 {
    public static void main(String[] args) {
        Customer customer = new Customer("Jane","Smith");
        Account account = new Account(1000,2000,0.0123);
        DecimalFormat df = new  DecimalFormat("0.00%");
        String annuall = df.format(account.getAnnuallnterestRate());
        customer.setAccount(account);
        account.deposit(100);
        account.withdraw(960);
        account.withdraw(2000);
        System.out.println("Customer [" + customer.getFirstName() + "," + customer.getLastName() + "] has a account: id is "
        + account.getId() + ",annuallnterestRate is " + annuall + ",balance is " + account.getBalance());
    }
}
