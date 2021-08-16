package com.qf.test0816.reflectiontest;

import com.qf.test0816.methods.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射操作类信息
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Class03Test {

    public static void main(String[] args) {

        try {
            //1.获取Class对象
            Class<?> clazz = Class.forName("com.qf.test0816.methods.Person");
            //2.反射为属性赋值
            //2.1 得到属性
            Person person = (Person) clazz.newInstance();
            //2.2 得到私有属性，暴力访问
            Field personId = clazz.getDeclaredField("personId");
            personId.setAccessible(true);
            personId.set(person,10);
            System.out.println(person);

            //3.反射调动方法
            Method run = clazz.getDeclaredMethod("run");
            run.invoke(person);

            //3.1 反射调用私有方法
            Method eat = clazz.getDeclaredMethod("eat", String.class, int.class);
            //设置暴力访问
            eat.setAccessible(true);
            eat.invoke(person,"大胃王面条",100);

            Method getPersonId = clazz.getDeclaredMethod("getPersonId");
            Object invoke = getPersonId.invoke(person);
            System.out.println(invoke);

            //4.调用构造器，创建对象
            Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.class, String.class);
            Person person1 = (Person) constructor.newInstance(100, "张三");
            System.out.println(person1);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
