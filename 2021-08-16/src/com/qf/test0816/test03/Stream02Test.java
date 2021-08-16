package com.qf.test0816.test03;

import com.qf.test0816.test02.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * API操作
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Stream02Test {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person(10,"张三10"));
        people.add(new Person(11,"张三11"));
        people.add(new Person(12,"张三12"));
        people.add(new Person(15,"张三15"));
        people.add(new Person(2,"张四2"));
        people.add(new Person(1,"张三1"));
        people.add(new Person(1,"张三1"));

        Stream<Person> stream = people.stream();

        //============================中间操作============================
        //获取Stream
        /*stream.filter(new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        });*/

        stream
                //过滤
                .filter(person -> person.getPersonName().startsWith("张"))
                //限定个数
//                .limit(3)
                //跳过：从第一个开始，跳过参数个
//                .skip(2L)
                //去重
                .distinct()
                //排序
//                .sorted(new Comparator<Person>() {
//                    @Override
//                    public int compare(Person o1, Person o2) {
//                        return o1.getPersonId() - o2.getPersonId();
//                    }
//                })
                .sorted((Comparator.comparingInt(Person::getPersonId)))
                //筛选
                .map(Person::getPersonName)
                //并行操作：多线程
                .parallel()
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------------");

        //============================终止操作============================
        //终止操作需要重新获取Stream对象
        //min
        /*Optional<Person> min = stream.min(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getPersonId() - o2.getPersonId();
            }
        });*/
        stream = people.stream();
        Optional<Person> min = stream.min(Comparator.comparingInt(Person::getPersonId));
        Person person1 = min.get();
        System.out.println(person1);

        System.out.println("---------------------------------------------------------");

        //max
        stream = people.stream();
        Optional<Person> max = stream.max(Comparator.comparingInt(Person::getPersonId));
        Person person2 = max.get();
        System.out.println(person2);

        System.out.println("---------------------------------------------------------");

        //count
        stream = people.stream();
        long count = stream.count();
        System.out.println(count);

        System.out.println("---------------------------------------------------------");

        //collect
        stream = people.stream();
//        List<Person> collect = stream.limit(3).collect(Collectors.toList());
        List<Person> collect = stream.collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("---------------------------------------------------------");

        //规约 reduce
        stream = people.stream();
        /*stream.map(Person::getPersonId).reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });*/
        Optional<Integer> reduce = stream.map(Person::getPersonId).reduce(Integer::sum);
        Integer result = reduce.get();
        System.out.println(result);


    }

}
