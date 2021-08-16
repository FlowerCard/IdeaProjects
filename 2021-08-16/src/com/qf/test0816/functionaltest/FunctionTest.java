package com.qf.test0816.functionaltest;

import java.util.function.Function;

/**
 * 函数接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class FunctionTest {

    public static void main(String[] args) {

        Function<String, Integer> fun1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };

        Function<String, Integer> fun2 = Integer::valueOf;
        System.out.println(fun2.apply("123"));

    }

}
