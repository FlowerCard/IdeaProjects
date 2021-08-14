package com.qf.test0812.test01;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/14.
 */
public class TcpCilentLogin {

    public static void main(String[] args) {

        //创建客户端Socket
        Socket socket;
        //实例化对象
        User user;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入Id：");
        String loginID = scanner.next();
        System.out.print("请输入密码：");
        String loginPWD = scanner.next();

        user = new User(loginID,loginPWD);

        OutputStream out;
        ObjectOutputStream oos;
        InputStream in;

        //登录
        try {
            socket = new Socket("localhost",8099);

            out = socket.getOutputStream();
            oos = new ObjectOutputStream(out);
            oos.writeObject(user);

            in = socket.getInputStream();
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(new String(bytes,0,len));
                System.out.println(new String(buffer));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
