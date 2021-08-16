package com.qf.test0816.operation;

import com.qf.test0816.operation.pojo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class StudentTest {

    public static void main(String[] args) {

        try {
            //获取Class对象
            Class<?> clazz = Class.forName("com.qf.test0816.operation.pojo.Student");
            Student student = null;

            //调用构造器创建对象
            Constructor<?> constructor = clazz.getDeclaredConstructor(Integer.class, String.class, String.class, Integer.class, Double.class);
            //创建对象
            Object newInstance = constructor.newInstance(1811020215, "花牌", "女", 20, 80.0);
            //判断类型
            if (newInstance instanceof Student) {
                student = (Student) newInstance;
                System.out.println(student);
            }
            //给学生加分
            Method plusScore = clazz.getDeclaredMethod("plusScore", Double.class);
            //设置暴力访问
            plusScore.setAccessible(true);
            //调用私有方法
            Object plusInvoke = plusScore.invoke(student, 20.5);
            System.out.println(plusInvoke);

            //给学生减分
            Method minusScore = clazz.getDeclaredMethod("minusScore", Double.class);
            //设置暴力访问
            minusScore.setAccessible(true);
            //调用私有方法
            Object minusInvoke = minusScore.invoke(student, 5.5);
            System.out.println(minusInvoke);

            //给学生修改性别
            Method changeGender = clazz.getDeclaredMethod("changeGender", String.class);
            //调用公有方法
            changeGender.invoke(student,"男");
            System.out.println(student);

            System.out.println("-------------------------我是分割线-------------------------");

            //调用无参构造器创建对象
            Object newInstance1 = clazz.newInstance();
            if (newInstance1 instanceof Student) {
                student = (Student) newInstance1;
            }

            //获取私有属性
            Field studentId = clazz.getDeclaredField("studentId");
            Field studentName = clazz.getDeclaredField("studentName");
            Field gender = clazz.getDeclaredField("gender");
            Field age = clazz.getDeclaredField("age");
            Field score = clazz.getDeclaredField("score");

            //设置暴力访问
            studentId.setAccessible(true);
            studentName.setAccessible(true);
            gender.setAccessible(true);
            age.setAccessible(true);
            score.setAccessible(true);

            //设置属性值
            studentId.set(student,10000001);
            studentName.set(student,"张三");
            gender.set(student,"女");
            age.set(student,22);
            score.set(student,99.2);
            //输出学生信息
            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
