package com.qf.test08031.test05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Test05 {

    public static Poker maxPoker(Poker p1,Poker p2) {
        if (p1.getN() > p2.getN()) {
            return p1;
        } else if (p1.getN() < p2.getN()) {
            return p2;
        }else {
            if (p1.getC() > p2.getC()) {
                return p1;
            }
            return p2;
        }
    }

    public static void main(String[] args) {
        int[] ins = {1,2,3,4};
        String[] strs = {"方块","草花","红心","黑桃"};
        List<Poker> list = new ArrayList<>();
        for (int j = 0; j < strs.length; j++) {
            for (int i = 1; i <= 13; i++) {
                Poker poker;
                if (i == 1) {
                    poker = new Poker(strs[j],"A",14,ins[j]);
                } else if (i == 11) {
                    poker = new Poker(strs[j],"J",11,ins[j]);
                } else if (i == 12) {
                    poker = new Poker(strs[j],"Q",12,ins[j]);
                } else if (i == 13) {
                    poker = new Poker(strs[j],"K",13,ins[j]);
                } else if (i == 2) {
                    poker = new Poker(strs[j],"2",15,ins[j]);
                }else {
                    poker = new Poker(strs[j],i+"",i,ins[j]);
                }
                list.add(poker);
            }
        }
        Collections.shuffle(list);
        System.out.println(list);

        TreeSet<Poker> treeSet = new TreeSet<>(list);
        System.out.println(treeSet);

        System.out.println(Test05.maxPoker(list.get(0),list.get(3)));
    }
}
