package com.qf.test0811.zuoye;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/11.
 *
 * 初始化一个长度为5的二维数组
 * 然后使用多线程计算总和
 * 要求每条线程计算一个一维数组
 */
public class Demo01 {

    public static void main(String[] args) {

        int[][] ints = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ints[i][j] = new Random().nextInt(100);
//                ints[i][j] = i + j;
            }
        }

        ExecutorService service = Executors.newFixedThreadPool(5);

        /**
         * 执行任务
         */
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            service.submit(new Runnable() {
                @Override
                public void run() {
                    int[] nums;
                    int sum = 0;
                    nums = ints[temp];

                    /**
                     * 查看每个线程拿到的数值
                     */
//                    System.out.println(Thread.currentThread().getName() + " -----> " + Arrays.toString(ints[temp]));

                    for (int j = 0; j < nums.length; j++) {
                        /**
                         * 计算值
                         */
                        sum += nums[j];
                    }
                    System.out.println(Thread.currentThread().getName() + " -----> " + sum);
                    System.out.println("----------------------------------------");
                }
            });
        }

        service.shutdown();

        while (!service.isTerminated()) {
            //等待所有的线程结束
        }

    }

}
