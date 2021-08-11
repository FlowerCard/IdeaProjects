package com.qf.test0811.test01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created on 2021/8/11.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyCallableTest {

    public static void main(String[] args) {

        //声明类
        MyCallable myCallable = new MyCallable();
        //创建 FutureTask 对象
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        //创建线程
        Thread thread = new Thread(futureTask);
        //运行线程
        thread.start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
