package com.qf.test07222;

public class TestArgsValue {
    public static void main(String[] args) {
        int i = 10;
        TestArgsValue tv = new TestArgsValue();
        tv.method1(i);
        System.out.println("i=" + i + "--1");

        System.out.println();
        Demo1 d = new Demo1();
        System.out.println(d + "---d1");
        tv.method2(d);
        System.out.println("d.i：" + d.i + "--2");
    }

    public void method1(int i){
        System.out.println("i=" + i++ + "--3");
    }

    public void method2(Demo1 d){
        System.out.println(d + "---d2");
        System.out.println("d.i：" + d.i++ + "--4");
    }

}

class Demo1{
    int i = 5;
}
