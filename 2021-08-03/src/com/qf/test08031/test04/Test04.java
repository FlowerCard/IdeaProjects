package com.qf.test08031.test04;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test04 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        //15只猴子
        for (int i = 1; i <= 15; i++) {
            integerList.add(i);
        }
        int count = 0;
        ListIterator<Integer> it = integerList.listIterator();
        while (integerList.size() != 1) {
            while (it.hasNext()) {
                it.next();
                count++;
                if (count % 7 == 0) {
                    it.remove();
                }
            }
            while (it.hasPrevious()) {
                it.previous();
            }
        }
        System.out.println("恭喜第" + integerList + "只成为猴王");
    }
}
