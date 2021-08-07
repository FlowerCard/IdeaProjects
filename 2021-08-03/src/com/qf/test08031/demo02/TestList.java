package com.qf.test08031.demo02;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList();
        for (int i = 1; i <= 20; i++) {
            //add(Element element) 将指定元素添加到这个列表的末尾
            list1.add(i);
        }
    }
}
