package com.qf.test04;

public class Test04 {
    public static void main(String[] args) {
        MyTime myTime = new MyTime();
        myTime.addHour(2);
        myTime.addMinute(30);
        myTime.addSecond(30);
        myTime.display();

        myTime.subHour(1);
        myTime.subMinute(20);
        myTime.subSecond(40);
        myTime.display();

    }
}
