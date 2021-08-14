package com.qf.test0812.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class TcpServerSignUp extends Thread {

    Properties properties = new Properties();

    public boolean checkUser(String check) {

        try {
            properties.load(new FileInputStream("user.properties"));

            if (properties.getProperty(check) == null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void run() {
        try {

            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("注册服务器启动了=============");

            while (true) {

                Socket socket = serverSocket.accept();
                Properties properties = new Properties();
                TcpServerSignUp singUp = new TcpServerSignUp();

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            //获取输入流
                            InputStream in = socket.getInputStream();
                            FileOutputStream out = new FileOutputStream("user.properties",true);
                            OutputStream serverOut = socket.getOutputStream();
                            String userSignUp;

                            int len;
                            byte[] bytes = new byte[1024];
                            StringBuffer buffer = new StringBuffer();
                            while ((len = in.read(bytes)) != -1) {
                                buffer.append(new String(bytes,0,len));
                            }
                            userSignUp = buffer.toString();
                            String[] userInfo = userSignUp.substring(1,buffer.length() - 1).split(",");
                            String check = userInfo[0].split(":")[1].trim();
                            if (singUp.checkUser(check)) {
                                properties.setProperty(check,userSignUp);
                                properties.store(out,"Sign UP");
                                serverOut.write(("注册成功 ---> " + serverSocket.getInetAddress().getHostAddress()).getBytes(StandardCharsets.UTF_8));
                                serverOut.flush();
                            } else {
                                serverOut.write(("注册失败---> " + serverSocket.getInetAddress().getHostAddress()).getBytes(StandardCharsets.UTF_8));
                                serverOut.flush();
                            }
                            socket.shutdownOutput();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).start();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
