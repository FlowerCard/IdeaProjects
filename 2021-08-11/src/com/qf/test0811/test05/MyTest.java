package com.qf.test0811.test05;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/11.
 *
 */
public class MyTest {

    /**
     * ConcurrentLinkedQueue
     * 并发性最好的队列
     */
    @Test
    public void testConcurrentLinkedQueue() {

        /**
         * 创建ConcurrentLinkedQueue
         */
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        /**
         * 创建线程池
         */
        ExecutorService service = Executors.newFixedThreadPool(3);

        /**
         * 提交任务
         */
        for (int i = 0; i < 3; i++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        /**
                         * queue 添加 内容
                         */
                        queue.add(j);
                    }
                }
            });
        }

        /**
         * 任务关闭
         */
        service.shutdown();

        while (!service.isTerminated()) {
            //等待所有的线程结束
        }

        /**
         * 遍历内容
         */
        for (Integer value : queue) {
            System.out.println("value = " + value);
        }

    }

    /**
     * ConcurrentHashMap
     * 是一个线程安全的HashMap
     *   JDK7：分段锁
     *   JDK8：synchronized + CAS【比较和交换，是由硬件搞定了】
     * 整个API操作跟HashMap一样
     */
    @Test
    public void testConcurrentHashMap() {

        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>();

        ExecutorService service = Executors.newFixedThreadPool(3);

//        for (int i = 0; i < 3; i++) {
//            final int temp = i;
//            service.submit(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 10; j++) {
//                        chm.put(temp * j + "", "tom" + temp * j);
//                    }
//                }
//            });
//        }

        Runnable chmPut = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 10; j++) {
                        chm.put(i * j + "", "tom" + i * j);
                    }
                }
            }
        };

        for (int i = 0; i < 3; i++) {
            service.submit(chmPut);
        }

        service.shutdown();

        while (!service.isTerminated()) {
            //等待所有的线程结束
        }

        for (String value : chm.keySet()) {
            System.out.println(chm.get(value));
        }


    }

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
