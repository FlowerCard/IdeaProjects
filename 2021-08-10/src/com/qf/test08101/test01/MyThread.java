package com.qf.test08101.test01;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyThread extends Thread{

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    /**
     * 重写 run 方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);

            try {
                //线程休眠
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 10) {
                //线程让步
                Thread.yield();
            }
        }
    }
}
