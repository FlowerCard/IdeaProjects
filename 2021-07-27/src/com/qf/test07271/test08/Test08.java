package com.qf.test07271.test08;

public class Test08 {
    public static void main(String[] args) {
        Person person = new Person();
        person.sleep();
        person.run();
        person.setName("东北虎");
        person.setAge(4);
        person.setSex("母");
        System.out.println(person.getName() + "," + person.getAge() + "," + person.getSex());
    }
}
