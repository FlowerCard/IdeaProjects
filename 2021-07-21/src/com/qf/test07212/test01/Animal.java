package com.qf.test07212.test01;

public class Animal {
	
	
	private String animalName;//��������
	private String breed;//����Ʒ��
	private int bodyLength;//������
	private int bodyWeight;//��������
	private String subject;//�����Ŀ
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getBodyLength() {
		return bodyLength;
	}
	public void setBodyLength(int bodyLength) {
		this.bodyLength = bodyLength;
	}
	public int getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(int bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void getAnimail() {
		System.out.println(this.animalName + "," + this.breed + "," + this.subject + "," + this.bodyLength + "," + this.bodyWeight);
	}
	
}
