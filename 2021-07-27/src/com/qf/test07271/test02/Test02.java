package com.qf.test07271.test02;

public class Test02 {
    public static void main(String[] args) {
        Calculate2 calculate2 = new Calculate2();
        int a;
        int b;
        int c;
        int d;
        a = calculate2.add(1,2);
        b = calculate2.subtraction(1,2);
        c = calculate2.division(1,2);
        d = calculate2.multiplication(1,2);
        System.out.println(a + "," + b + "," + c + "," + d);
    }
}
