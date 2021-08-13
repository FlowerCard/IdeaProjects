package com.java2105.huangzihao.test01;

import java.util.Arrays;
import java.util.Random;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 */
public class Test01 {

    public static void main(String[] args) {

        //生成20个随机数
        int[] arrs = new int[20];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = new Random().nextInt(20);
        }

        System.out.println("第一步：产生0-20的随机数");
        System.out.println(Arrays.toString(arrs));
        System.out.println();

        /*
         * 求和
         * 平均数
         * 最大值
         * 最小值
         */
        //求和
        double sum = 0;
        for (int arr : arrs) {
            sum += arr;
        }

        //平均数
        double avg = sum / arrs.length;

        //最大值，最小值
        Arrays.sort(arrs);
        int max = arrs[arrs.length - 1];
        int min = arrs[0];
        System.out.println("第二步：求和求平均值");
        System.out.println("和：" + sum);
        System.out.println("平均值：" + avg);
        System.out.println("最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println();

        //升序后的数组内容
        System.out.println("第三步：数组升序");
        System.out.println(Arrays.toString(arrs));

        //统计数组第十个数出现的次数
        int count = 0;
        int tenPos = arrs[9];
        for (int arr : arrs) {
            if (arr == tenPos) {
                count++;
            }
        }
        System.out.println("第四步：数组中第10个数是" + tenPos + "，总共出现了" + count + "次");

    }

}
