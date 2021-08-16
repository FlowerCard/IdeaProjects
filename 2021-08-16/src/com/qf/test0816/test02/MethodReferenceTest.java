package com.qf.test0816.test02;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        //消费型接口
        Consumer<Integer> con1 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer * 100);
            }
        };
        //方法引用
//        Consumer<Integer> con2 = integer -> System.out.println(integer);
        //类::静态方法
        Consumer<Integer> con2 = System.out::println;
        con2.accept(100);

        System.out.println("--------------------------------------------------------------");

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

//        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1,o2);
        //类::静态方法
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(20, 30));

        //类::静态方法
        Comparator<String> com3 = String::compareTo;
        System.out.println(com3.compare("AAA", "ADA"));

        System.out.println("--------------------------------------------------------------");

        //类::实例方法
        Function<Person,String> fun1 = new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.getPersonName();
            }
        };

//        Function<Person,String> fun2 = person -> person.getPersonName();
        Function<Person,String> fun2 = Person::getPersonName;
        System.out.println(fun2.apply(new Person(10, "张三")));

        System.out.println("--------------------------------------------------------------");

        //类::new
        Supplier<Person> sup1 = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };

//        Supplier<Person> sup2 = () -> new Person();
        Supplier<Person> sup2 = Person::new;
        System.out.println(sup2.get());


    }

}
