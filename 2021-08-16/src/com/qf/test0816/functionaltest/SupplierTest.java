package com.qf.test0816.functionaltest;

import java.util.function.Supplier;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class SupplierTest {

    public static void main(String[] args) {

        Integer x = 100;
        Integer y = 200;
        Supplier<Integer> sup1 = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return x * y;
            }
        };

        Supplier<Integer> sup2 = () -> x * y;
        System.out.println(sup2.get());

    }

}
