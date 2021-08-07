package com.qf.test11;

import java.text.DecimalFormat;

public class Test11 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(6);
        double area = circle.findArea();
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(area));
    }
}
