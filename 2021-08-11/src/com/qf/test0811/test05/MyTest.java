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
     * BlockingQueue
     * 阻塞队列
     * 分类
     *  无界队列：LinkedBlockingQueue
     */
    @Test
    public void testLinkedBlockingQueue() {

        /**
         * 创建LinkedBlockingQueue
         */
        BlockingQueue<String> queue = new LinkedBlockingDeque<String>();

        for (int i = 0; i < 10; i++) {
            try {
                /**
                 * 使用 LinkedBlockingQueue 的 put 方法需要捕获异常
                 */
                queue.put("tom" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String value : queue) {
            System.out.println("value = " + value);
        }

        System.out.println("----------------------------我是分割线-----------------------------");

        try {
            queue.put("jack");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (String value : queue) {
            System.out.println("value = " + value);
        }

        System.out.println("----------------------------我是分割线-----------------------------");

    }

    /**
     * BlockingQueue
     * 阻塞队列
     * 分类
     *  有界队列：ArrayBlockingQueue
     */
    @Test
    public void testArrayBlockingQueue() {
        /**
         *  创建ArrayBlockingQueue
         *  这个类有三个带参构造器
         *  使用该类的 put 方法，这个方式是线程安全的
         */
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        for (int i = 0; i < 5; i++) {
            /**
             * 使用 put 方法需要捕获 InterruptedException 异常
             */
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Integer value : queue) {
            System.out.println(value);
        }

        System.out.println("------------------我是分割线------------------");

        try {
            //如果不从放满的队列中取出一个值，后面要进队列的数据将无法进入队列
            Integer value = queue.take();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------------我是分割线------------------");

        //使用 put 方法存入元素时，如果队列是满的，就会无期限的等待，直到这个队列有空的位置
        try {
            queue.put(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Integer value : queue) {
            System.out.println("value = " + value);
        }

        System.out.println("------------------我是分割线------------------");

    }

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

        /**
         * 创建ConcurrentHashMap
         */
        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>();

        /**
         * 创建线程池
         */
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

        /**
         * 创建CopyOnWriteArraySet
         */
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
