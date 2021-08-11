package com.qf.test0811.test03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class TicketLockTest {

    public static void main(String[] args) {

        /**
         * 创建有3个线程的线程池
         * 模拟3个票务窗口
         */
        ExecutorService service = Executors.newFixedThreadPool(3);

        TicketLock ticketLock = new TicketLock();

        for (int i = 0; i < 3; i++) {
            service.submit(ticketLock);
        }

        service.shutdown();

    }

}
