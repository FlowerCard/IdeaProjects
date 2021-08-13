package com.qf.test0812.test01;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class TcpCilent01 {

    public static void main(String[] args) {

        Socket socket = null;
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

        properties.put("id" + System.currentTimeMillis(),userInfo);
        OutputStream out = null;

        try {
            socket = new Socket("localhost",8088);
//            out = new FileOutputStream("user.properties");
            out = socket.getOutputStream();
            properties.store(out,"Sign up");
            socket.shutdownOutput();
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
