package com.qf.test07212.test01;

public class Test01 {
	
	public static void main(String[] args) {
		Person person = new Person();
		Animal animal = new Animal();
		ClassRoom classRoom = new ClassRoom();
		Zoo zoo = new Zoo();
		
		person.setName("����");
		person.setSex("��");
		person.setHeight(180);
		person.setWeight(65);
		person.getPerson();
		
		animal.setAnimalName("������");
		animal.setBreed("����");
		animal.setSubject("è��");
		animal.setBodyLength(280);
		animal.setBodyWeight(180);
		animal.getAnimail();
		
		classRoom.setClassName("Java2105");
		classRoom.setClassMemberNumber(56);
		classRoom.setSeatNumber(60);
		classRoom.setWide(100);
		classRoom.setLength(100);
		classRoom.getClassRoom();
		
		zoo.setZooName("�����԰");
		zoo.setAnimalType("ʳ�⶯��");
		zoo.setAnimalNumber(10000);
		zoo.getZoo();
		
	}

}
