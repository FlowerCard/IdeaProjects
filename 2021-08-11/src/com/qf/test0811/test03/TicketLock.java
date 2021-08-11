package com.qf.test0811.test03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 *
 * Lock要放到 线程池中，所以要实现 Runnable 接口
 */
public class TicketLock implements Runnable {

    private Integer ticket = 100;
    /**
     * 创建Lock，使用 Lock 的实现类 ReentrantLock 来实现操作
     */
    private Lock locker = new ReentrantLock();

    @Override
    public void run() {
        //上锁
        locker.lock();
        try {
            while (true) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " ------> 出票：" + ticket--);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        } finally {
            //手动解锁
            locker.unlock();
        }
    }
}
