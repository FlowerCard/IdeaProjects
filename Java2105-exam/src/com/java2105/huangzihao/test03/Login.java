package com.java2105.huangzihao.test03;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class Login {

    public static void main(String[] args) {

        //创建 Properties
        Properties properties = new Properties();
        //创建 Scanner
        Scanner scanner = new Scanner(System.in);
        try {
            //读取 properties 文件内容
            properties.load(new FileInputStream("user.properties"));
            System.out.println("用户登录");
            System.out.print("请输入用户名：");
            String username = scanner.next();
            System.out.print("请输入密码：");
            String password = scanner.next();
            //比较内容
            if (properties.getProperty("username").equals(username) && properties.getProperty("password").equals(password)) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
