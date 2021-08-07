package com.qf.test07222.test01;

public class Test01 {
    public static void main(String[] args) {
        Box box = new Box();
        int surfaceArea = 0;
        int volume = 0;
        surfaceArea = box.surfaceArea(20,10);
        volume = box.volume(20,10,5);
        System.out.println(surfaceArea);
        System.out.println(volume);
    }
}
