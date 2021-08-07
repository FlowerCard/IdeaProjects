package com.qf.test07302.test04;

public class Test04 {
    public static void main(String[] args) {
        Vehicle vehicle = null;
        vehicle = new Car();
        System.out.println(vehicle.NoOfWhells());
        vehicle = new Motorbike();
        System.out.println(vehicle.NoOfWhells());
    }
}
