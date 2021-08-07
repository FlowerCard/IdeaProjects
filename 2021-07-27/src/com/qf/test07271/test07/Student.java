package com.qf.test07271.test07;

public class Student extends Person{
    private String sex;

    public Student(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }

    @Override
    public void showInfo(){
        System.out.println(super.name + "," + super.age + "," + this.sex);
    }

}
