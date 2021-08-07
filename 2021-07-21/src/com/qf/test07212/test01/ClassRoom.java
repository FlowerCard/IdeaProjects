package com.qf.test07212.test01;

public class ClassRoom {
	
	private String className;
	private int seatNumber;
	private int classMemberNumber;
	private double length;
	private double wide;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getClassMemberNumber() {
		return classMemberNumber;
	}
	public void setClassMemberNumber(int classMemberNumber) {
		this.classMemberNumber = classMemberNumber;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWide() {
		return wide;
	}
	public void setWide(double wide) {
		this.wide = wide;
	}
	
	public void getClassRoom() {
		System.out.println(this.className + "," + this.classMemberNumber + "," + this.seatNumber + "," + this.length + "," + this.wide);
	}

}
