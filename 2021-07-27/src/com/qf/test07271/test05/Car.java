package com.qf.test07271.test05;

public class Car extends Auto{
    private boolean air;
    private boolean cd;

    public Car(){
        this.air = true;
        this.cd = true;
    }

    public Car(boolean air){
        this.air = air;
        this.cd = true;
    }

    public Car(boolean air,boolean cd){
        this.air = air;
        this.cd = cd;
    }

    @Override
    public void speedUp(){
        System.out.println("加两倍速");
    }

    @Override
    public void speedDown(){
        System.out.println("减两倍速");
    }

}
