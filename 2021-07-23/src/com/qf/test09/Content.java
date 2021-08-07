package com.qf.test09;

public class Content {

    /**
     * 比较大小，输出最大值
     * @param a 比较数1
     * @param b 比较数2
     */
    public Content(int a,int b){
        System.out.println(Math.max(a,b));
    }

    /**
     * 相乘
     * @param a 乘数1
     * @param b 乘数2
     * @param c 乘数3
     */
    public Content(double a,double b,double c){
        System.out.println(a*b*c);
    }

    /**
     * 字符串拼接
     * @param a 字符串1
     * @param b 字符串2
     */
    public Content(String a, String b){
        System.out.println(a+b);
    }

}
