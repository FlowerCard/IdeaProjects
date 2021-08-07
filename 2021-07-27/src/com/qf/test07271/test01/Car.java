package com.qf.test07271.test01;

public class Car extends Vehicles{
    private int seats;

    public Car(){
        super();
        this.seats = 4;
    }

    public Car(String brand, String color, int seats) {
        super(brand, color);
        this.seats = seats;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void showCar(){
        System.out.println(super.getBrand() + "," + super.getColor() + "," + this.seats + "座");
    }

}
