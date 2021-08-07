package com.qf.test08031.demo01;

import java.util.Date;
import java.util.LinkedHashSet;

public class TestLinkedHashSet {
    public static void main(String[] args) {
        //双向链表保证元素的顺序
        LinkedHashSet set = new LinkedHashSet();
        set.add("a");
        set.add("a");
        set.add(1);
        set.add(2);
        set.add(2);
        set.add("b");
        set.add(new Date());
        set.add(new Person("tom",10));
        set.add(new Person("tom",10));

        System.out.println(set);
    }
}
