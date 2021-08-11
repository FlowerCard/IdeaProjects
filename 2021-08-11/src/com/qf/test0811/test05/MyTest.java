package com.qf.test0811.test05;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
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
     * CopyOnWriteArraySet
     * 底层使用的是 CopyOnWriteArrayList
     * CopyOnWriteArraySet 的add方法，其实就是调用了 addIfAbsent()，这个方法就是CopyOnWriteArrayList的
     */
    @Test
    public void testCopyOnWriteArraySet() {

        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();

        ExecutorService service = Executors.newFixedThreadPool(3);

        Runnable setAdd = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    set.add(i);
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            service.submit(setAdd);
        }

        service.shutdown();
        while (!service.isTerminated()) {
            //等待所有线程结束
        }

        for (Integer value : set) {
            System.out.println("value = " + value);
        }

    }

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
