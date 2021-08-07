package com.qf.test07271.test01;

public class Vehicles {
    protected String brand;
    protected String color;

    protected void run(){
        System.out.println("我已经开动了");
    }

    protected void showInfo(){
        System.out.println(color + "，" + brand);
    }

    public Vehicles() {
        this.color = "黑色";
        this.brand = "奔驰";
    }

    public Vehicles(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
