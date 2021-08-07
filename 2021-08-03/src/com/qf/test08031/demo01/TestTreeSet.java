package com.qf.test08031.demo01;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        /*
        只能存储一种数据类型
        自身有一个升序排序
        */
        TreeSet treeSet = new TreeSet();
//        treeSet.add(5);
//        treeSet.add(6);
//        treeSet.add(3);
//        treeSet.add(1);
//        treeSet.add(2);
//        treeSet.add(4);
//        System.out.println(treeSet);
//        treeSet.add("e");
//        treeSet.add("b");
//        treeSet.add("c");
//        treeSet.add("f");
//        treeSet.add("d");
//        treeSet.add("a");
//        System.out.println(treeSet);
        /*
        先按姓名排序，再按年龄排序
        姓名相等然后排年龄
         */
//        treeSet.add(new Person("cc",10));
//        treeSet.add(new Person("cc",10));
//        treeSet.add(new Person("bb",10));
//        treeSet.add(new Person("bb",9));
//        treeSet.add(new Person("aa",11));
//        System.out.println(treeSet);

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    int a = p1.getName().compareTo(p2.getName());
                    if (a == 0) {
                        return p1.getAge() - p2.getAge();
                    }
                    return a;
                }
                return 0;
            }
        };

        TreeSet treeSet1 = new TreeSet(comparator);

        treeSet1.add(new Person("cc",10));
        treeSet1.add(new Person("cc",10));
        treeSet1.add(new Person("bb",10));
        treeSet1.add(new Person("bb",9));
        treeSet1.add(new Person("aa",11));
        System.out.println(treeSet1);

    }
}
