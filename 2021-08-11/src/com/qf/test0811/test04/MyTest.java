package com.qf.test0811.test04;

import org.junit.Test;

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
    public void test01(){
        MyReentrantReaderWriteLock myLocker = new MyReentrantReaderWriteLock();

        /**
         * 实现 2 个线程写
         * 实现 18 个线程读
         */
        ExecutorService service = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 2; i++) {
            myLocker.setValue(i);
        }

        for (int i = 0; i < 18; i++) {
            System.out.println(myLocker.getValue());
        }


    }

}
