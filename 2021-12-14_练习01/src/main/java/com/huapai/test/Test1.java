package com.huapai.test;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/12/15.
 */
public class Test1 {

    public static void add3(Integer i) {
        int val = i.intValue();
        val += 3;
        i = new Integer(val);
    }
    public static void main(String args[]) {
        Integer i = new Integer(0);
        add3(i);
        System.out.println(i.intValue());
    }


}
