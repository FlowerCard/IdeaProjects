package com.qf.test0812.test01;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class TcpCilentSignUp {

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

        System.out.println("客户机启动了======================");

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

//        String userInfo = user.toString();
//        System.out.println(userInfo);
//        properties.put(user.getId(),userInfo);

        OutputStream out = null;
        ObjectOutputStream oos = null;
        InputStream in = null;
//        ObjectInputStream ois = null;


        try {
            socket = new Socket("localhost",8088);

            //获得输出流
            out = socket.getOutputStream();
            oos = new ObjectOutputStream(out);
            oos.writeObject(user);
//            properties.store(out,"Sign up");
            socket.shutdownOutput();

            in = socket.getInputStream();
            StringBuffer buffer = new StringBuffer();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                buffer.append(new String(bytes,0,len));
                System.out.println(new String(buffer));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
