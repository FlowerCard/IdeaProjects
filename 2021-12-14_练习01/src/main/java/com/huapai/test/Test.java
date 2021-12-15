package com.huapai.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 */
public class Test {
    
    @org.junit.Test
    public void test01() {
        Integer a=80, b = 80;
        Integer c=150, d = 150;
        System.out.println(a == b);
        System.out.println(c == d);

    }
    
    @org.junit.Test
    public void test02() {
        ArrayList list = new ArrayList(Arrays.asList("a","b","c","d"));
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i);
            list.remove(i);
        }
        System.out.println(list);
    }
    
}
