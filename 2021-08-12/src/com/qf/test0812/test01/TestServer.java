package com.qf.test0812.test01;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/14.
 */
public class TestServer {

    public static void main(String[] args) {

        new TcpServerSignUp().start();
        new TcpServerLogin().start();

    }

}
