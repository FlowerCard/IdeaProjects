package com.qf.test08031.demo01;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        /*
        没有提供额外的方法
        无序 != 随机
        set 如何保障无序，不重复  1、调用hashcode()来决定存储位置   2、equals 保证是否重复
         */
        Set set = new HashSet();
        set.add("a");
        set.add("a");
        set.add(1);
        set.add(2);
        set.add(2);
        set.add("b");
        set.add(new Date());
        set.add(new Person());
        set.add(new Person());

        System.out.println(set);
    }
}
