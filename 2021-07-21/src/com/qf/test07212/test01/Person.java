package com.qf.test07212.test01;

public class Person {
	
	public Person() {
		
	}

	private String name;
	private String sex;
	private int height;
	private int weight;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
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
	
	public void getPerson() {
		System.out.println(this.name + "," + this.sex + "," + this.height + "," + this.weight);
	}

}
