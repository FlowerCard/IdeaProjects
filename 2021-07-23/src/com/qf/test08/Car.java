package com.qf.test08;

import com.qf.test07222.test02.Vehicle;

import java.time.Year;

public class Car {
    private int tire;
    private String color;
    private double weight;
    private Vehicle vehicle;

    /**
     * 构造默认值
     */
    public Car(){
        this.tire = 4;
        this.color = "黑色";
        this.weight = 1.5;
        this.vehicle = new Vehicle();
    }

    /**
     * 构造时设置轮胎数量
     * @param tire  轮胎数量
     */
    public Car(int tire){
        if (tire <= 0){
            System.out.println("车辆需要轮胎，请重新输入");
        }else{
            this.tire = tire;
        }
        this.vehicle = new Vehicle();
        this.color = "黑色";
        this.weight = 1.5;
    }

    /**
     * 构造时设置轮胎数量，车辆颜色
     * @param tire  轮胎数量
     * @param color 车辆颜色
     */
    public Car(int tire,String color){
        if (tire <= 0){
            System.out.println("车辆需要轮胎，请重新输入");
        }else{
            this.tire = tire;
        }
        this.color = color;
        this.vehicle = new Vehicle();
        this.weight = 1.5;
    }

    /**
     * 构造时设置轮胎数量，车辆颜色，车辆重量
     * @param tire      轮胎数量
     * @param color     车辆颜色
     * @param weight    车辆重量
     */
    public Car(int tire,String color,long weight){
        if (tire <= 0){
            System.out.println("车辆需要轮胎，请重新输入");
        }else{
            this.tire = tire;
        }
        this.color = color;
        if (weight <= 0){
            System.out.println("车辆是有重量的，单位为 t");
        }else{
            this.weight = weight;
        }
        this.vehicle = new Vehicle();
    }

    /**
     *
     *  @return 获取轮胎数量
     */
    public int getTire() {
        return tire;
    }

    /**
     * 轮胎数量
     * @param tire  输入轮胎数量
     *              轮胎不应该小于0，或者等于0
     */
    public void setTire(int tire) {
        if (tire <= 0){
            System.out.println("车辆需要轮胎，请重新输入");
        }else{
            this.tire = tire;
        }
    }

    /**
     *
     * @return  获取车辆颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置车辆颜色
     * @param color 传入颜色名字
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return  获取车辆重量，单位为 t
     */
    public double getWeight() {
        return weight;
    }

    /**
     * 设置车辆重量，单位为 t。车辆有重量，请合理设置
     * @param weight 传入重量
     */
    public void setWeight(double weight) {
        if (weight <= 0){
            System.out.println("车辆是有重量的，单位为 t");
        }else{
            this.weight = weight;
        }
    }

    /**
     * 车辆启动
     */
    public void carStart(){
        if (tire == 0){
            System.out.println("无法启动");
        }else {
            System.out.println("车辆启动");
        }
    }

    /**
     * 车辆加速
     */
    public void speedUp(){
        if (this.tire == 0){
            System.out.println("车辆无法启动");
        } else {
            this.vehicle.speedUp();
            System.out.println("车辆加速，当前速度为：" + vehicle.getSpeed());
        }
    }

    /**
     * 车辆减速
     */
    public void speedDown(){
        if (this.tire == 0){
            System.out.println("车辆无法启动");
        }else {
            this.vehicle.speedDown();
            System.out.println("车辆减速，当前速度为：" + vehicle.getSpeed());
        }
    }

    /**
     * 车联停止
     */
    public void carStop(){
        if (tire == 0){
            System.out.println("车辆无法启动");
        }else {
            System.out.println("车辆停止");
        }
    }

    public void dispaly(){
        System.out.println("车辆信息：");
        System.out.println("轮胎" + this.tire + "个,颜色：" + this.color + ",重量" + this.weight + "t");
    }

}
