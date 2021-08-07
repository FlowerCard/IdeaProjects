package com.qf.test07302.test02;

public class StaticDemo02 {
    private static String name;

    public static void main(String[] args) {
        StaticDemo02.setName("Test01");
        StaticDemo02 st01 = new StaticDemo02();
        StaticDemo02 st02 = new StaticDemo02();
        StaticDemo02 st03 = new StaticDemo02();
        System.out.println();
    }

    public StaticDemo02() {
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StaticDemo02.name = name;
    }


}
