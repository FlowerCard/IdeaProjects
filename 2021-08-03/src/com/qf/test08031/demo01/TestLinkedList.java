package com.qf.test08031.demo01;

import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        /*
        特点：基于双向链表实现的，双向链表不是一个连续的存储空间
        通过双向链表维护元素之间的顺序
        增删效率高，查询效率慢
         */
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.addFirst("aa");
        list.addLast("bb");

        System.out.println(list);

        //peekFirst 和 peekLast 获取元素不改变原有集合
        System.out.println(list.peekFirst());
        System.out.println(list.peekLast());
        System.out.println(list);

        //pollFirst 和 pollList 获取元素并改变原有集合
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        System.out.println(list);
    }
}
