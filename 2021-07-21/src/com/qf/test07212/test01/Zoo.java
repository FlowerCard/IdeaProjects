package com.qf.test07212.test01;

public class Zoo {
	
	private String zooName;
	private String animalType;
	private int animalNumber;
	private Animal animal;
	
	
	public String getZooName() {
		return zooName;
	}
	public void setZooName(String zooName) {
		this.zooName = zooName;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public int getAnimalNumber() {
		return animalNumber;
	}
	public void setAnimalNumber(int animalNumber) {
		this.animalNumber = animalNumber;
	}
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public void getZoo() {
		System.out.println(this.zooName + "," + this.animalType + "," + this.animalNumber );
	}
	

}
