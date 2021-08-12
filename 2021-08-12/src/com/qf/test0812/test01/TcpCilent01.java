package com.qf.test0812.test01;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class TcpCilent01 {

    public static void main(String[] args) {

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

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("user.txt"));
            oos.writeObject(user);
            ois = new ObjectInputStream(new FileInputStream("user.txt"));
            in = new FileInputStream(new File("user.txt"));
            out = new FileOutputStream("user.properties");
            int len;
            byte[] bytes = new byte[1024];
            Object object = ois.readObject();
            if (object instanceof User) {
                User user1 = (User) object;
                System.out.println(user1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
