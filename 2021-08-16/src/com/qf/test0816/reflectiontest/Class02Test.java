package com.qf.test0816.reflectiontest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射API
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Class02Test {

    public static void main(String[] args) {

        try {
            //1.获取Class对象
            Class<?> clazz = Class.forName("com.qf.test0816.methods.Person");

            //2.创建对象
            //没有无参构造器会产生的异常 --> Caused by: java.lang.NoSuchMethodException: com.qf.java2105.pojo.Person.<init>()
            Object o = clazz.newInstance();
            System.out.println(o);

            //3.获取类中的信息
            //3.1 获取全类名
            String name = clazz.getName();
            System.out.println(name);

            //3.2 获取包名
            Package packageName = clazz.getPackage();
            System.out.println(packageName);

            //3.3 获取父类
            Class<?> superclass = clazz.getSuperclass();
            System.out.println(superclass);

            //3.4 获取接口数组
            Class<?>[] interfaces = clazz.getInterfaces();
            System.out.println("接口数组：");
            for (Class<?> anInterface : interfaces) {
                System.out.println("anInterface = " + anInterface.getName());
            }

            System.out.println("----------------------------------------------------");

            //3.5 获取属性
            //获取公开的属性
            Field[] fields1 = clazz.getFields();
            System.out.println("公开属性");
            for (Field field : fields1) {
                System.out.println(field.getName());
            }

            //获取全部的属性数组
            Field[] fields2 = clazz.getDeclaredFields();
            System.out.println("全部属性");
            for (Field field : fields2) {
                System.out.println(field.getName());
            }

            //3.6 获取方法
            //获取公开的方法
            Method[] methods1 = clazz.getMethods();
            System.out.println("公开的方法");
            for (Method method : methods1) {
                System.out.println(method);
            }

            //获取全部的方法
            Method[] methods2 = clazz.getDeclaredMethods();
            System.out.println("全部的方法数组：");
            for (Method method : methods2) {
                System.out.println(method);
            }

            //3.7 获取构造器
            //公开的构造器
            Constructor<?>[] constructors1 = clazz.getConstructors();
            System.out.println("公开的构造器数组：");
            for (Constructor<?> constructor : constructors1) {
                System.out.println(constructor);
            }

            //全部的构造器
            Constructor<?>[] constructors2 = clazz.getDeclaredConstructors();
            System.out.println("全部的构造器数组：");
            for (Constructor<?> constructor : constructors2) {
                System.out.println(constructor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
