package com.qf.test05;

public class Test05  {

    public static void main(String[] args) {
        Noodle noodle = new Noodle();
        Noodle noodle1 = new Noodle("细",6);
        Noodle noodle2 = new Noodle("宽",8,true);
        Noodle noodle3 = new Noodle("宽",8,true,8);

        noodle.showNoodleInfo();
        System.out.println();
        noodle1.showNoodleInfo();
        System.out.println();
        noodle2.showNoodleInfo();
        System.out.println();
        noodle3.showNoodleInfo();

    }

}
