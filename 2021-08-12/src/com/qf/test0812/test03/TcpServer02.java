package com.qf.test0812.test03;

import sun.reflect.generics.scope.Scope;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ghy
 * @version 1.0
 * @date 2021-08-12
 **/
public class TcpServer02 {

    public static void main(String[] args) throws IOException {
        //1.创建服务器Socket
        ServerSocket serverSocket = new ServerSocket(10087);

        System.out.println("服务器启动了============");
        while (true) {
            //2.接收客户端，accept() : 就可以获取到给我发送数据的客户端Socket
            Socket socket = serverSocket.accept();
            //通过输入流获取消息
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String info = br.readLine();
            System.out.println("我是服务器：接收到客户端的数据-->" + info + "，客户端ip为" + socket.getInetAddress().getHostAddress());

            System.out.println("服务器接收消息成功");

            //-----
            //服务器回消息给客户端
            OutputStream out = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            bw.write("我是服务器，欢迎您访问！！");
            bw.newLine();
            bw.flush();
        }


        //服务器不能停止
        //serverSocket.close();

    }

}
