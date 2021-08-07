package com.qf.test07222;

public class TestA {

    int i;

    void change(int i){
        i++;
        System.out.println(i);
    }

    void change1(TestA t){
        t.i++;
        System.out.println(t.i);
    }

    public static void main(String[] args) {
        TestA testA = new TestA();
        System.out.println(testA.i);// 0
        testA.change(testA.i);//i++
        System.out.println(testA.i);// 1
        testA.change1(testA);
        System.out.println(testA.i);
    }

}
