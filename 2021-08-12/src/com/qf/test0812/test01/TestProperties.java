package com.qf.test0812.test01;

import org.omg.PortableServer.POA;

import java.io.*;
import java.util.*;

public class TestProperties {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();



        FileInputStream fileIn = new FileInputStream("user.properties");
        properties.load(fileIn);
        String value = properties.getProperty("1001");
        String[] info = value.substring(1,value.length() - 1).split(",");
        String userInfo = info[2].split(":")[1].trim();
        System.out.println(userInfo);

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userTest.properties"));
//        user = new User("1001","tom","123",20,60.0);
//        oos.writeObject(user);
//        oos.flush();
//        oos.close();
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userTest.properties"));
//        Object object = ois.readObject();
//        if (object instanceof User) {
//            User user1 = (User) object;
//            properties.load(fileIn);
//            Set<String> propertyNames = properties.stringPropertyNames();
//            Iterator<String> iterator = propertyNames.iterator();
//            while (iterator.hasNext()) {
//                if (iterator.next().equals(user1.getId())) {
//                    flag = false;
//                }
//            }
//
//            if (flag) {
//                FileOutputStream out = new FileOutputStream("user.properties",true);
//                properties.store(out,"Sign up");
//            } else {
//                System.out.println("注册失败");
//            }
//
//        }



        /*properties.load(new FileInputStream("user.properties"));
        Set<String> set = properties.stringPropertyNames();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        /*User user;
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
        }*/

    }

}
