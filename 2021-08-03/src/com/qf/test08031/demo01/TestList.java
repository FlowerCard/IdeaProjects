package com.qf.test08031.demo01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class TestList {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add("aa");
        list1.add("aa");
        list1.add("cc");
        list1.add(new Person("tom",10));

        list1.add(1,new Date());
        System.out.println(list1);

        List list2 = new ArrayList();
        list2.add(111);
        list2.add(222);
        list1.addAll(1,list1);
//        System.out.println(list1.get(2));
//        for (int i = 0; i < list1.size(); i++) {
//            System.out.println(list1.get(i));
//        }

        System.out.println(list1.indexOf("aa"));
        System.out.println(list1.lastIndexOf("aa"));
        list1.set(0,"abc");
        //返回列表中指定的 fromIndex（包括 ）和 toIndex（不包括）之间的部分视图
        System.out.println(list1.subList(0,3));
        System.out.println(list1);

        System.out.println("-------------------------------");

        ListIterator lt = list1.listIterator();
        while (lt.hasNext()) {
            System.out.println(lt.next());
        }

        System.out.println("-------------------------------");
        //如果以逆向遍历列表，列表迭代器有多个元素，则返回
        while (lt.hasPrevious()) {
            //返回列表中的前一个元素
            System.out.println(lt.previous());
        }
    }
}
