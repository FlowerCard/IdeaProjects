package com.work.test;

import com.work.pojo.User;
import com.work.service.ILoginService;
import com.work.service.impl.LoginServiceImpl;

import java.util.Scanner;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/23.
 */
public class Login {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ILoginService loginService = new LoginServiceImpl();
        User user = null;
        String useraccount = null;
        String username = null;
        String password = null;

        System.out.println("====================欢迎进入=========================");
        System.out.println("=====================1、注册=========================");
        System.out.println("=====================2、登录=========================");
        System.out.println("=====================3、按任意键退出=========================");
        String chose = scanner.next();
        if ("1".equals(chose)) {
            System.out.println("请输入注册账号：");
            useraccount = scanner.next();
            System.out.println("请输入注册用户名：");
            username = scanner.next();
            System.out.println("请输入注册密码：");
            password = scanner.next();
            user = new User(useraccount,username,password,0D);
            boolean signUp = loginService.signUp(user);
            if (signUp) {
                System.out.println("注册成功");
            } else {
                System.out.println("注册失败");
            }
        } else if ("2".equals(chose)) {
            System.out.println("默认登录用户名：123@163.com，密码：123");
            System.out.print("请输入用户名：");
            username = scanner.next();
            System.out.print("请输入密码：");
            password = scanner.next();
            boolean login = loginService.login(username, password);
            if (login) {
                System.out.println("登录成功");
            } else {
                System.out.println("登录失败");
            }
        } else {
            System.exit(0);
        }


    }

}
