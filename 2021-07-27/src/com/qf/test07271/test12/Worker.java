package com.qf.test07271.test12;

public class Worker extends Employee{
    private char category;//类别
    private boolean dressAllowance;//是否提供服装津贴

    public Worker(String name, char sex, char category, boolean dressAllowance) {
        super(name, sex);
        this.category = category;
        this.dressAllowance = dressAllowance;
    }

    public void isDressAll(){
        if (this.dressAllowance){
            System.out.println("提供服装津贴");
        }else {
            System.out.println("不提供服装津贴");
        }
    }

}
