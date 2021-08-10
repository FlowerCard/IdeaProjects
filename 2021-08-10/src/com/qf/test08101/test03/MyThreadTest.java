package com.qf.test08101.test03;

/**
 * Created on 2021/8/10.
// *
// * @author HuaPai
// * @email HuaPai@odcn.live
// */
public class MyThreadTest {
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("t1");
        MyThread myThread2 = new MyThread("t2");
        MyThread myThread3 = new MyThread("t3");

        //设置优先级，默认是5 ，值越大，优先级越高
        myThread1.setPriority(1);
        myThread2.setPriority(10);

        myThread1.start();
        myThread2.start();
        myThread3.start();

    }
}
