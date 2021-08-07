package com.qf.test03;

public class Test03 {
    public static void main(String[] args) {
        WuMingFen f1 = new WuMingFen("牛肉",3,true);
        WuMingFen f2 = new WuMingFen("牛肉",2);
        WuMingFen f3 = new WuMingFen();
        f1.check();
        f2.check();
        f3.check();
    }
}
