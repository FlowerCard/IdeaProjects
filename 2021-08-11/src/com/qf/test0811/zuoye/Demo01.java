package com.qf.test0811.zuoye;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
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

        /**
         * 其中一个数组长度随机生成
         */
        int[][] ints = new int[5][new Random().nextInt(50)];

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                /**
                 * 赋值随机数
                 */
                ints[i][j] = new Random().nextInt(100);
                /**
                 * 赋值循环相加数
                 */
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
                     * 查看每个线程拿到的一维数组
                     */
                    System.out.println(Thread.currentThread().getName() + " -----> " + Arrays.toString(ints[temp]));

                    for (int j = 0; j < nums.length; j++) {
                        /**
                         * 计算值
                         */
                        sum += nums[j];
                    }
                    list.add(sum);
                    System.out.println(Thread.currentThread().getName() + " -----> " + sum);
                    System.out.println("----------------------------------------");

//                    System.out.println(sumArr);
//                    System.out.println("----------------------------------------");
                }
            });
        }

        service.shutdown();

        while (!service.isTerminated()) {
            //等待所有的线程结束
        }

        /**
         * list 求和
         */
        int sumArr = 0;
        for (int i = 0; i < list.size(); i++) {
            sumArr += list.get(i);
            /**
             * 查看 list 内容
             */
//            System.out.println(i + " ----> " + list.get(i));
        }
        System.out.println(sumArr);

    }

}
