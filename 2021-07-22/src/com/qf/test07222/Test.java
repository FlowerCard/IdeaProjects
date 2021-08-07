package com.qf.test07222;

public class Test {
    public static void leftShift(int i,int j){
        i+=j;
    }

    public static void main(String[] args) {
        int i = 4;
        int j = 2;
        leftShift(i,j);
        System.out.println(i);
    }

}
