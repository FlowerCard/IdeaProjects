package com.qf.test07212.tset02;

public class Player {
	private int height;
	private int weight;
	private String name;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void getPlayer() {
		System.out.println(name + "," + height + "cm," + weight + "kg");
	}
	
}
