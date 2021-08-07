package com.qf.test07302.test01;

public class StaticDemo01 {
    private static int aStatic = 10;
    private int b = 5;

    @Override
    public String toString() {
        return "StaticDemo{" +
                "b=" + this.b +
                '}';
    }

    public static int getaStatic() {
        return aStatic;
    }

    public static void setaStatic(int aStatic) {
        StaticDemo01.aStatic = aStatic;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        StaticDemo01 staticDemo01 = new StaticDemo01();
        System.out.println(staticDemo01.getB());
        System.out.println(StaticDemo01.getaStatic());
    }
}
