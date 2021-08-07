package com.qf.test07212.test01;

public class Test01 {
	
	public static void main(String[] args) {
		Person person = new Person();
		Animal animal = new Animal();
		ClassRoom classRoom = new ClassRoom();
		Zoo zoo = new Zoo();
		
		person.setName("张三");
		person.setSex("男");
		person.setHeight(180);
		person.setWeight(65);
		person.getPerson();
		
		animal.setAnimalName("东北虎");
		animal.setBreed("豹属");
		animal.setSubject("猫科");
		animal.setBodyLength(280);
		animal.setBodyWeight(180);
		animal.getAnimail();
		
		classRoom.setClassName("Java2105");
		classRoom.setClassMemberNumber(56);
		classRoom.setSeatNumber(60);
		classRoom.setWide(100);
		classRoom.setLength(100);
		classRoom.getClassRoom();
		
		zoo.setZooName("疯狂动物园");
		zoo.setAnimalType("食肉动物");
		zoo.setAnimalNumber(10000);
		zoo.getZoo();
		
	}

}
