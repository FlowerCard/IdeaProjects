package com.banking;

public class Bank {
    private Customer[] customers;
    private int numberOfCustomer;

    public Bank(){
        customers = new Customer[10];
    }

    /**
     * 添加客户
     * @param firstName 名字
     * @param lastName  姓氏
     */
    public void addCustomer(String firstName,String lastName){
        Customer customer = new Customer(firstName,lastName);
        this.customers[this.numberOfCustomer] = customer;
        this.numberOfCustomer++;
    }

    public int getNumberOfCustomer() {
        return this.numberOfCustomer;
    }

    public void getCustomer(int index){
        for (int i=0 ; i<this.customers.length ; i++){
            if (index == i){
                System.out.println(this.customers[index].getFirstName() + "," + this.customers[index].getLastName());
            }
        }
    }
}
