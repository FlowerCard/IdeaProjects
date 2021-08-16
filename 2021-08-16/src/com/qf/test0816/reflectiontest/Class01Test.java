package com.qf.test0816.reflectiontest;

import com.qf.test0816.methods.Person;

/**
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Class01Test {

    public static void main(String[] args) {

        try {
            //1.类名.class
            Class<Person> personClass1 = Person.class;
            System.out.println("personClass1 = " + personClass1);

            //2.对象名.getClass()
            Person person = new Person();
            Class<? extends Person> personClass2 = person.getClass();
            System.out.println("personClass2 = " + personClass2);

            //3.Class.forName(全限定类名)
            Class<?> forName = Class.forName("com.qf.test0816.methods.Person");
            System.out.println("forName = " + forName);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
