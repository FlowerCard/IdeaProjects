package com.huapai.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 */
public class Test {
    
    @org.junit.Test
    public void test01() {
        Integer a=80, b = 80;
        Integer c=150, d = 150;
        System.out.println(a == b);
        System.out.println(c == d);

    }
    
    @org.junit.Test
    public void test02() {
        ArrayList list = new ArrayList(Arrays.asList("a","b","c","d"));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
            list.remove(i);
        }
        System.out.println(list);
    }
    
    @org.junit.Test
    public void test03() {
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
