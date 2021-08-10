package com.qf.test08101.test01;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyThreadTest {
    public static void main(String[] args) {
        //创建线程
        MyThread myThread = new MyThread();
        //线程命名
        myThread.setName("t1");

        //创建线程的同时，指定线程名词
        MyThread myThread2 = new MyThread("t2");

        //启动线程
        myThread2.start();
        myThread.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "======>" + i);
            try {
                //线程休眠
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
