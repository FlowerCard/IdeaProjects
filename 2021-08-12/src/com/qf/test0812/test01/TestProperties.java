package com.qf.test0812.test01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

public class TestProperties {

    public static void main(String[] args) {

        Properties properties = new Properties();

        User user;
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String pwd;
        Integer age;
        Double score;
        System.out.print("请输入ID：");
        id = scanner.next();
        System.out.print("请输入姓名：");
        name = scanner.next();
        System.out.print("请输入密码：");
        pwd = scanner.next();
        System.out.print("请输入年龄：");
        age = scanner.nextInt();
        System.out.print("请输入分数：");
        score = scanner.nextDouble();

        user = new User(id,name,pwd,age,score);

        String userInfo = user.toString();
        System.out.println(userInfo);

        properties.setProperty("id",userInfo);
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("user.properties");
            out.flush();
            properties.store(out,"");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
