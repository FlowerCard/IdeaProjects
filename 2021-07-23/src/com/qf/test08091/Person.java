package com.qf.test08091;

public class Person {
    private String name;
    private int age;

    public Person(){
        this.name = "α";
        this.age = 30;
    }

    public void display(){
        System.out.println("name:" + this.name);
        System.out.println("age:" + this.age);
    }

}
