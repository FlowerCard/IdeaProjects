package com.qf.test07222;

public class Demo {

    public static void main(String[] args) {
        int[] a = new int[1];
        modify(a);
        System.out.println(a[0]);
    }

    public static void modify(int[] a){
        a[0]++;
    }

}
