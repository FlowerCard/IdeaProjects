package com.qf.test07222.test02;

public class Test02 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setSize(200);
        vehicle.setSpeed(60);

        vehicle.move(300);
        vehicle.speedUp();
        vehicle.speedDown();

    }
}
