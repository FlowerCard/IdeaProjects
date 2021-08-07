package com.qf.test07302.test05;

public class interfaceDemo {
    public static void main(String[] args) {
        Vehicle vehicle = null;
        vehicle = new Bike();
        vehicle.start("凤凰");
        vehicle.stop("凤凰");

        vehicle = new Bus();
        vehicle.start("363路");
        vehicle.stop("363路");
    }
}
