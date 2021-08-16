package com.qf.test0816.functionaltest;

import java.util.function.Predicate;

/**
 * 断言型接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<Integer> pre1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 100;
            }
        };

        Predicate<Integer> pre2 = integer -> integer > 100;
        System.out.println(pre2.test(50));

    }

}
