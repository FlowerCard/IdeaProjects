package com.qf.test0812.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/14.
 */
public class TcpServerLogin {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8099);
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
            //登录
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取输入流
                        InputStream in = finalSocket.getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(in));
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
                                    flag = true;
                                    String value = properties.getProperty(user.getId());
                                    String[] info = value.substring(1,value.length() - 1).split(",");
                                    String userPwd = info[2].split(":")[1].trim();
                                    if (user.getPwd().equals(userPwd)) {
                                        flag = true;
                                    }
                                }
                            }
                            //服务器给客户机回消息
                            if (flag) {
//                                properties.store(out,"Sign up");
                                serverOut.write("登录成功".getBytes(StandardCharsets.UTF_8));
                                serverOut.flush();
                            } else {
                                serverOut.write("登录失败".getBytes(StandardCharsets.UTF_8));
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
