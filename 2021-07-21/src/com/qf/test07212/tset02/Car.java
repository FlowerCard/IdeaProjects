package com.qf.test07212.tset02;

public class Car {
	private String carColor;
	private String brand;
	private String license;
	private long price;
	
	
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public void getCar() {
		System.out.println(carColor + "," + brand + "," + license + "," + price );
	}
	
}
