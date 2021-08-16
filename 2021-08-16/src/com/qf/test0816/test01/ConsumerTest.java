package com.qf.test0816.test01;

import java.util.function.Consumer;

/**
 * 消费型接口
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class ConsumerTest {

    public static void main(String[] args) {

        //先使用匿名内部类
        Consumer<Integer> con1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer o) {
                System.out.println("lambda表达式练习");
            }
        };

        Consumer<Integer> con2 = o -> System.out.println("lambda表达式练习 ---> " + o);
        con2.accept(100);

    }

}
