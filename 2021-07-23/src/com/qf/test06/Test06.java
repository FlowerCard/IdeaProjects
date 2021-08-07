package com.qf.test06;

public class Test06 {
    public static void main(String[] args) {
        Addition addition = new Addition();
        System.out.println(addition.Addition(2,3));
        System.out.println(addition.Addition(3000000330L,3000002020L));
        System.out.println(addition.Addition(50.3F,55.2F));
        System.out.println(addition.Addition(2002.11,20202.22));
        System.out.println(addition.Addition("Hello","World"));
    }
}
