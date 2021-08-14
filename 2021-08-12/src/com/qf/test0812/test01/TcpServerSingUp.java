package com.qf.test0812.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class TcpServerSingUp {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器启动了=============");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = new Socket();
            Properties properties = new Properties();

            try {
                assert serverSocket != null;
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Socket finalSocket = socket;
            //注册
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取输入流
                        InputStream in = finalSocket.getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(in));
                        FileOutputStream out = new FileOutputStream("user.properties",true);
                        OutputStream serverOut = finalSocket.getOutputStream();
                        Object object = ois.readObject();
                        if (object instanceof User){
                            User user = (User) object;
                            Boolean flag = false;
                            properties.load(new FileInputStream("user.properties"));
                            Set<String> names = properties.stringPropertyNames();
                            Iterator<String> iterator = names.iterator();
                            while (iterator.hasNext()) {
                                if (iterator.next().equals(user.getId())) {
                                    flag = false;
                                }
                            }
                            //服务器给客户机回消息
                            if (flag) {
                                properties.store(out,"Sign up");
                                serverOut.write("注册成功".getBytes(StandardCharsets.UTF_8));
                                serverOut.flush();
                            } else {
                                serverOut.write("注册失败".getBytes(StandardCharsets.UTF_8));
                                serverOut.flush();
                            }
                        }
                        finalSocket.shutdownOutput();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        }

    }

}
