package com.qf.test0812.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        InputStream ois = null;


        try {
            serverSocket = new ServerSocket(8088);

            Socket socket = serverSocket.accept();

//            ois = new ObjectInputStream(new FileInputStream("user.properties"));

            StringBuffer buffer = new StringBuffer();
            ois = socket.getInputStream();

            FileOutputStream out = new FileOutputStream(new File("user.properties"));

            int len;
            byte[] bytes = new byte[1024];
            while ((len = ois.read(bytes)) != -1) {
//                buffer.append(new String(bytes,0,len));
                out.write(bytes,0,len);
            }
            socket.shutdownOutput();
//            System.out.println(buffer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
