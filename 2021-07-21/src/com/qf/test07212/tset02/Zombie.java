package com.qf.test07212.tset02;

public class Zombie {
	
	private String name;
	private int physical;
	private int atk;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhysical() {
		return physical;
	}
	public void setPhysical(int physical) {
		this.physical = physical;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public void getZombie() {
		System.out.println(name + "," + physical + "," + atk);
	}

}
