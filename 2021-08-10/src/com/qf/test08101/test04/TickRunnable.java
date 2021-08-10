package com.qf.test08101.test04;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class TickRunnable implements Runnable {

    private int ticket = 100;

    Object object = new Object();

    //同步方法，锁对象 ---> this
    public synchronized void sellTicket(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出票，票号为：" + ticket);
            ticket--;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {

        while (true) {
            sellTicket();
        }

        /*while (true) {
            //同步代码块
            //() 中写锁对象，锁对象必须唯一，且被多个线程共享。注意：该对象必须是引用数据类型，可以是任意对象
            synchronized (object) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出票，票号为：" + ticket);
                    ticket--;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/

        /*while (true) {
            //同步代码块
            //() 中写锁对象，锁对象必须唯一，且被多个线程共享。注意：该对象必须是引用数据类型，可以是任意对象
            synchronized (this) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "正在出票，票号为：" + ticket);
                    ticket--;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }*/

    }
}
