package com.qf.test08031.test03;

import java.util.*;

public class LikeArraysList {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);
        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-----------------------");

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }

        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }

}
