package com.qf.test12;

import com.qf.test07231.test11.Circle;

public class PassObject {

    public void printAreas(Circle c,int time){
        for (int i = 1 ; i<=time ; i++){
            System.out.print(i + ",");
            c.setRadius(i);
            System.out.println();
            System.out.print(c.findArea() + ",");
        }
    }

}
