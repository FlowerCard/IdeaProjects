package com.qf.test02;

public class Test02 {
    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        System.out.println("初始名字：" + demo02.getName());
        demo02.setName("θ");
        System.out.println("setName：" + demo02.getName());
    }
}
