package com.qf.test0811.test02;

import java.util.concurrent.*;

/**
 * 计算 1 - 100 的和
 * 使用 Future 接口
 * Created on 2021/8/11.
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class MyCallableTest {

    public static void main(String[] args) {

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(2);

        Callable<Integer> c1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //计算 1 - 50
                Integer sum = 0;
                for (int i = 1; i < 51; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        Callable<Integer> c2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //计算 51 - 100
                Integer sum = 0;
                for (int i = 51; i < 101; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        Future<Integer> future1 = service.submit(c1);
        Future<Integer> future2 = service.submit(c2);

        try {
            Integer sum1 = future1.get();
            System.out.println(sum1);
            Integer sum2 = future2.get();
            System.out.println(sum2);

            System.out.println(sum1 + sum2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

    }

}
