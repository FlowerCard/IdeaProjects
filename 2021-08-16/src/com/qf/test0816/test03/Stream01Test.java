package com.qf.test0816.test03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Stream01Test {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("刘一");
        list.add("陈二");
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("孙七");

        //通过集合的stream方法获取Stream对象
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        System.out.println("----------------------------------");

        //parallelStream() 并行流
        Stream<String> stream2 = list.parallelStream();
        stream2.forEach(System.out::println);

        System.out.println("----------------------------------");

        Integer[] nums = {10,20,30,40,50,60,70};
        Stream<Integer> stream3 = Arrays.stream(nums);
        stream3.forEach(System.out::println);

        System.out.println("----------------------------------");

        Stream<Integer> stream4 = Stream.of(100, 200, 300, 400);
        stream4.forEach(System.out::println);

        System.out.println("----------------------------------");
        //迭代流
        //参数一：开始的数
        //参数二：迭代规则
        /*Stream<Integer> stream = Stream.iterate(100, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        });*/
        Stream<Integer> stream5 = Stream.iterate(100,n -> n * 2);
        //limit()限制次数
        stream5 = stream5.limit(5);
        stream5.forEach(System.out::println);

        System.out.println("----------------------------------");
        //生成流
        /*Stream<Integer> stream = Stream.generate(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        });*/
        Stream<Integer> stream6 = Stream.generate(() -> new Random().nextInt(100));
        //limit()限制次数
        stream6 = stream6.limit(5);
        stream6.forEach(System.out::println);

        System.out.println("----------------------------------");
        //IntStream
        //of
        IntStream stream7 = IntStream.of(100,200,300,400,500);
        stream7.forEach(System.out::println);

        System.out.println("----------------------------------");
        //range
        //参数一：开始位置
        //参数二：结束位置
        //( 开始位置,结束位置 ) ----> 开区间
        IntStream stream8 = IntStream.range(10,20);
        stream8.forEach(System.out::println);

        System.out.println("----------------------------------");
        //rangeClosed
        //参数一：开始位置
        //参数二：结束位置
        //( 开始位置,结束位置 ] ----> 左开右闭区间
        IntStream stream9 = IntStream.rangeClosed(10,20);
        stream9.forEach(System.out::println);

    }

}
