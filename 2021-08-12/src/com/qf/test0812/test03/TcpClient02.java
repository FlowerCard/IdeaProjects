package com.qf.test0812.test03;

import java.io.*;
import java.net.Socket;

/**
 * @author ghy
 * @version 1.0
 * @date 2021-08-12
 **/
public class TcpClient02 {

    public static void main(String[] args) throws IOException {

        //如果服务器没有启动，则会报错：java.net.ConnectException: Connection refused: connect

        //1.创建Socket对象
        Socket socket = new Socket("182.61.20.91", 10087);

        System.out.println("客户端启动了.......");

        //2.向服务器发送消息，使用的是输出流
        OutputStream out = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        bw.write("我是客户端，向服务器问好！！");
        bw.newLine();
        //把内存中数据写出去
        bw.flush();

        System.out.println("-----------客户端发送消息成功------------------");

        //------
        //接收服务器回应消息
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //读一行。在写过来的时候，必须也是一行
        String info = br.readLine();
        System.out.println("我是客户端：接收到服务器的数据-->" + info);

        socket.close();


    }

}
