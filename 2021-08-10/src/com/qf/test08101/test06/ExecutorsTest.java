package com.qf.test08101.test06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2021/8/10.
 *
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class ExecutorsTest {

    public static void main(String[] args) {
        //创建一个线程池，里面的线程3个
        ExecutorService service = Executors.newFixedThreadPool(3);

        //内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "这是一个任务------------------------->");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 8; i++) {
            service.execute(runnable);
        }

        /*
            手动停止：
                shutdown()会等待任务执行完毕之后再结束
                shutdownNow()会直接结束，不考虑任务是否运行完成
         */
        service.shutdown();
    }

}
