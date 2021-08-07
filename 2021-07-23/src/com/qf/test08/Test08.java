package com.qf.test08;

public class Test08 {
    public static void main(String[] args) {
        Car car = new Car();
        car.carStart();
        car.speedUp();
        car.speedUp();
        car.speedUp();
        car.carStop();
        car.dispaly();

        Car car1 = new Car(6);
        car1.carStart();
        car1.speedUp();
        car1.speedDown();
        car1.carStop();
        car1.dispaly();

        Car car2 = new Car(12,"白色");
        car2.carStart();
        car2.speedUp();
        car2.speedUp();
        car2.carStop();
        car2.carStop();
        car2.dispaly();

        Car car3 = new Car(12,"彩色",9);
        car3.carStart();
        car3.speedUp();
        car3.speedUp();
        car3.speedUp();
        car3.speedDown();
        car3.carStop();
        car3.dispaly();

    }
}
