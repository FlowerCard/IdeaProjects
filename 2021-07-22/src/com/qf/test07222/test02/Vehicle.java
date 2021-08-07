package com.qf.test07222.test02;

public class Vehicle {

    private double speed;
    private int size;

    /**
     * 设置速度
     * @param speed 输入速度
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * 设置体积
     * @param size  输入体积
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 加速
     */
    public void speedUp(){
        this.speed++;
        System.out.println("当前速度为：" + this.speed);
    }
    /**
     * 加速
     * @param speed 输入加速度
     */
    public void speedUp(double speed){
        this.speed += speed;
        System.out.println("当前速度为：" + this.speed);
    }

    /**
     * 减速
     */
    public void speedDown(){
        this.speed--;
        System.out.println("当前速度为：" + this.speed);
    }

    /**
     * 减速
     * @param speed 输入减速度
     */
    public void speedDown(double speed){
        this.speed -= speed;
        System.out.println("当前速度为：" + this.speed);
    }

    /**
     * 移动距离
     * @param t 移动距离
     */
    public void move(int t){
        System.out.println("移动了：" + t);
    }

}
