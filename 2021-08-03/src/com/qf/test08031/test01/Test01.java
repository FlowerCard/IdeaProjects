package com.qf.test08031.test01;

import java.util.Comparator;
import java.util.TreeSet;

public class Test01 {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        Employee employee1 = new Employee("tom",18,new MyDate(1999,10,10));
        Employee employee2 = new Employee("tom",10,new MyDate(1999,10,02));
        treeSet.add(employee1);
        treeSet.add(employee2);
        System.out.println(treeSet);

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    int a = e1.getBirthday().compareTo(e2.getBirthday());
                    return a;
                }
                return 0;
            }
        };

        treeSet = new TreeSet(comparator);
        treeSet.add(employee1);
        treeSet.add(employee2);
        System.out.println(treeSet);
    }

}
