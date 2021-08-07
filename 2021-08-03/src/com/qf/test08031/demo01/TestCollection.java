package com.qf.test08031.demo01;

import java.util.*;

public class TestCollection {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(1);
        c1.add(true);
        c1.add(10.1);
        c1.add(new Date());
        c1.add("abc");
        c1.add(new Person("tom",10));

        Collection c2 = new ArrayList();
        c2.add("aa");
        c2.add("bb");

        //追加指定集合的所有元素到这个列表的末尾，按他们的指定集合的迭代器返回
        c1.addAll(c2);

        c2.add("cc");

        System.out.println(c2);
        System.out.println(c1);
        //从这个列表中移除所有的元素
//        c1.clear();
//        System.out.println(c1);

        //返回 true如果这个列表包含指定元素
        System.out.println(c1.contains(1));
        System.out.println(c1.contains("abc"));
        //如果此 collection 包含指定 collection 中的所有元素，则返回 true
        System.out.println(c1.containsAll(c2));

        Collection c3 = new ArrayList();
        c3.add("aa");
        c3.add("bb");
        c3.add("cc");
        System.out.println(c2.equals(c3));
        System.out.println(c2.isEmpty());
        //从这个集合中移除指定元素的一个实例，如果它是存在的
        System.out.println(c1.remove(1));
        //删除此集合中包含的所有元素（可选操作）的所有元素
//        System.out.println(c1.removeAll(c2));
        System.out.println(c1);
        System.out.println(c1.size());
        //仅保留包含在指定集合中的这个集合中的元素
//        System.out.println(c1.retainAll(c2));
//        System.out.println(c1);
        Object[] objs = c1.toArray();
        System.out.println(Arrays.toString(objs));

        //Iterator 实现类如何得到，必须是 集合.iterator（）得到接口对象
        Iterator it1 = c1.iterator();
        while (it1.hasNext()) {
            Object obj = it1.next();
            System.out.println(obj);
            if (obj.equals("aa")){
                it1.remove();
            }
        }
        System.out.println(c1);
    }
}
