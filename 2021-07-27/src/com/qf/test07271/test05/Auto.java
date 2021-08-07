package com.qf.test07271.test05;

public class Auto {
    private int tires;
    private String color;
    private int weight;
    private int speed;

    public Auto(){
        this.tires = 4;
        this.color = "黑色";
        this.weight = 4;
        this.speed = 240;
    }

    /**
     * 构造方法
     * @param tires 轮胎数量
     */
    public Auto(int tires) {
        this.tires = tires;
        this.color = "黑色";
        this.weight = 4;
        this.speed = 240;
    }

    /**
     * 构造方法
     * @param tires 轮胎数量
     * @param color 车辆颜色
     */
    public Auto(int tires, String color) {
        this.tires = tires;
        this.color = color;
        this.weight = 4;
        this.speed = 240;
    }

    /**
     * 构造方法
     * @param tires     轮胎数量
     * @param color     车辆颜色
     * @param weight    车身重量
     */
    public Auto(int tires, String color, int weight) {
        this.tires = tires;
        this.color = color;
        this.weight = weight;
        this.speed = 240;
    }

    /**
     * 构造方法
     * @param tires     轮胎数量
     * @param color     车辆颜色
     * @param weight    车身重量
     * @param speed     速度
     */
    public Auto(int tires, String color, int weight, int speed) {
        this.tires = tires;
        this.color = color;
        this.weight = weight;
        this.speed = speed;
    }

    public void speedUp() {
        System.out.println("加速");
    }

    public void speedDown(){
        System.out.println("减速");
    }

    public void stop(){
        System.out.println("停车");
    }

}
