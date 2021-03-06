package com.qf.test0811.test04;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyTest {

    @Test
    public void test02(){
        MyLock myLock = new MyLock();
        ExecutorService service = Executors.newFixedThreadPool(20);

        Runnable write = new Runnable() {
            @Override
            public void run() {
                myLock.setValue(new Random().nextInt(100));
            }
        };

        Runnable read = new Runnable() {
            @Override
            public void run() {
                Integer value = myLock.getValue();
            }
        };

        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            service.submit(write);
        }

        for (int i = 0; i < 18; i++) {
            service.submit(read);
        }

        service.shutdown();

        while (!service.isTerminated()) {
            //等待所有线程结束
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    @Test
    public void test01(){
        MyReentrantReaderWriteLock myLocker = new MyReentrantReaderWriteLock();

        /**
         * 实现 2 个线程写
         * 实现 18 个线程读
         */
        ExecutorService service = Executors.newFixedThreadPool(20);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    myLocker.setValue(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    Integer value = myLocker.getValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            service.submit(runnable1);
        }

        for (int i = 0; i < 18; i++) {
            service.submit(runnable2);
        }

        service.shutdown();

        while (!service.isTerminated()) {
            //等待所有线程结束
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }

}
