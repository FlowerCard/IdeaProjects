package com.qf.test11;

public class Circle {
    private double radius;

    /**
     * 计算圆的面积
     * @return 返回计算的圆面积
     */
    public double findArea(){
        return Math.PI * Math.pow(radius,2);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
