package com.qf.test07271.test01;

public class Truck extends Vehicles{
    private float load;

    public Truck() {
        this.load = 4;
    }

    public float getLoad() {
        return this.load;
    }

    public void setLoad(float load) {
        this.load = load;
    }

    public void showTruck(){
        System.out.println(super.getBrand() + "," + super.getColor() + "," + this.getLoad() + "t");
    }

}
