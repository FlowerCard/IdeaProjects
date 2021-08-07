package com.qf.test07271.test07;

public class Person {
    protected String name;
    protected int age;

    public Person(){
        this.name = "test01";
        this.age = 0;
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void showInfo(){
        System.out.println(this.name + "," + this.age);
    }

}
