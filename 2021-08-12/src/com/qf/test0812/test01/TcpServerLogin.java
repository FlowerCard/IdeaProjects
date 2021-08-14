package com.qf.test0812.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/14.
 */
public class TcpServerLogin extends Thread {

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8099);
            System.out.println("登录服务器启动了=============");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = new Socket();
            Properties properties = new Properties();
            OutputStream serverOut = null;

            try {
                assert serverSocket != null;
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Socket finalSocket = socket;
            //登录
            try {
                //获取输入流
                InputStream in = finalSocket.getInputStream();
                serverOut = finalSocket.getOutputStream();
                Boolean flag = false;
                properties.load(new FileInputStream("user.properties"));
                int len;
                byte[] bytes = new byte[1024];
                StringBuffer buffer = new StringBuffer();
                while ((len = in.read(bytes)) != -1) {
                    buffer.append(new String(bytes,0,len));
                }
//                        String info = buffer.toString();
                String[] userInfo = buffer.toString().split(",");
                Iterator<String> iterator = properties.stringPropertyNames().iterator();
                while (iterator.hasNext()) {
                    String temp = iterator.next();
                    if (temp.equals(userInfo[0])) {
                        String value = properties.getProperty(temp);
                        String[] values = value.substring(1,value.length() - 1).split(",");
                        String userValue = values[2].split(":")[1].trim();
                        if (userValue.equals(userInfo[1])) {
                            flag = true;
                        }
                    }
                }
                //服务器给客户机回消息
                if (flag) {
                    serverOut.write("登录成功".getBytes(StandardCharsets.UTF_8));
                    serverOut.flush();
                } else {
                    serverOut.write("登录失败".getBytes(StandardCharsets.UTF_8));
                    serverOut.flush();
                }
                finalSocket.shutdownOutput();
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    serverOut.write("没有此用户".getBytes(StandardCharsets.UTF_8));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
