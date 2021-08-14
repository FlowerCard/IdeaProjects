package com.qf.test0812.test01;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/14.
 */
public class TcpCilent {

    //创建客户端Socket
    private Socket socket;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        TcpCilent cilent = new TcpCilent();
        System.out.println("请选择业务：");
        System.out.println("1、登录");
        System.out.println("2、注册");
        try {
            Integer num = scanner.nextInt();
            if (num == 1) {
                cilent.Login();
            } else if (num ==2){
                cilent.SignUp();
            } else {
                System.out.println("请选择正确的序号");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("请选择正确的序号");
        }



    }

    public void Login() {

        System.out.print("请输入Id：");
        String loginID = scanner.next();
        System.out.print("请输入密码：");
        String loginPWD = scanner.next();

        String userLogin = loginID + "," + loginPWD;

        OutputStream out;
        ObjectOutputStream oos;
        InputStream in;

        //登录
        try {
            socket = new Socket("localhost",8099);

            out = socket.getOutputStream();
            out.write(userLogin.getBytes());
            socket.shutdownOutput();
            in = socket.getInputStream();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(new String(bytes,0,len));
                System.out.println(new String(buffer));
            }
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void SignUp() {
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

        String userSignUp = "{id:" + id + ", name:" + name + ", pwd:" + pwd + ", age:" + age + ", score:" + score
                + "}";
        OutputStream out = null;
        ObjectOutputStream oos = null;
        InputStream in = null;


        try {
            socket = new Socket("localhost",8088);
            //获得输出流
            out = socket.getOutputStream();
            out.write(userSignUp.getBytes(StandardCharsets.UTF_8));
            socket.shutdownOutput();

            in = socket.getInputStream();
            StringBuffer buffer = new StringBuffer();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                buffer.append(new String(bytes,0,len));
                System.out.println(new String(buffer));
            }
            socket.shutdownInput();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
