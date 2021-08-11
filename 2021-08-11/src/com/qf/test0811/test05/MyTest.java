package com.qf.test0811.test05;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/11.
 *
 */
public class MyTest {

    /**
     * CopyOnWriteArrayList
     * 底层使用的是 Lock 锁保证线程安全
     */
    @Test
    public void testCopyOnWriteArrayList(){
        /**
         * 创建 CopyOnWriteArrayList
         */
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        /**
         * 创建线程池
         */
        ExecutorService service = Executors.newFixedThreadPool(3);

        /**
         * 创建任务
         */
        Runnable listAdd = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            /**
             * 提交任务
             */
            service.submit(listAdd);
        }

        /**
         * 结束
         */
        service.shutdown();
        while (!service.isTerminated()) {
            //等待所有线程结束
        }

        /**
         * 遍历 list
         */
        for (Integer value : list) {
            System.out.println("value = " + value);
        }

    }

}
