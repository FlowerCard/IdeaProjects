package com.qf.test07212.tset02;

public class Test02 {
	public static void main(String[] args) {
		Car car = new Car();
		car.setCarColor("��ɫ");
		car.setBrand("��������");
		car.setLicense("��A��000000");
		car.setPrice(100000000);
		car.getCar();
		
		car.setCarColor("��ɫ");
		car.setBrand("��������");
		car.setLicense("��A��000000");
		car.setPrice(100000000);
		car.getCar();
		
		Player player = new Player();
		player.setName("Ҧ��");
		player.setHeight(220);
		player.setWeight(140);
		player.getPlayer(); 
		
		player.setName("�Ʊ�");
		player.setHeight(198);
		player.setWeight(96);
		player.getPlayer();
		
		Zombie zombie = new Zombie();
		zombie.setName("Zom1");
		zombie.setPhysical(100);
		zombie.setAtk(1200);
		zombie.getZombie();
		
		zombie.setName("Zom2");
		zombie.setPhysical(85);
		zombie.setAtk(12000);
		zombie.getZombie();
		
		zombie.setName("Zom3");
		zombie.setPhysical(30);
		zombie.setAtk(5600);
		zombie.getZombie();
	}
}
