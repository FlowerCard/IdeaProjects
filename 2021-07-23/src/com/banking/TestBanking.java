package com.banking;

public class TestBanking {
    public static void main(String[] args) {
        Customer customer = new Customer("Smith","Jane");
        Account account = new Account(500);
        Bank bank = new Bank();
        account.withdraw(150);
        account.deposit(22.5);
        account.withdraw(47.62);
        account.withdraw(400);
//        System.out.println(account.getBalance());

        customer.setAccount(account);
        System.out.println(customer.getFirstName() + "," + customer.getLastName() + "," + customer.getAccount().getBalance());

        bank.addCustomer("Simms","Jane");
        bank.addCustomer("Braynt","Owen");
        bank.addCustomer("Soley","Tim");
        bank.addCustomer("Soley","Maria");
        bank.getCustomer(0);
        bank.getCustomer(1);
        bank.getCustomer(2);
        bank.getCustomer(3);

    }
}
