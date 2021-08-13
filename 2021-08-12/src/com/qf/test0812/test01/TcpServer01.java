package com.qf.test0812.test01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = new Socket();

        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }


            Socket finalSocket = socket;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

//                      ois = new ObjectInputStream(new FileInputStream("user.properties"));

                        StringBuffer buffer = new StringBuffer();
                        InputStream ois = finalSocket.getInputStream();

                        FileOutputStream out = new FileOutputStream(new File("user.properties"));

                        int len;
                        byte[] bytes = new byte[1024];
                        while ((len = ois.read(bytes)) != -1) {
//                buffer.append(new String(bytes,0,len));
                            out.write(bytes,0,len);
                        }
                        finalSocket.shutdownOutput();
//            System.out.println(buffer.toString());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }

}
