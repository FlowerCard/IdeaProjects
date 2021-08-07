package test01;

public class Person {
	
	String name;
	int age;
	String sex;
	
	/**
	 *    	输出studying
	 */
	public void study() {
		System.out.println("studying");
	}
	
	/**
	 * 	输出age
	 */
	public void showAge() {
		System.out.println(age);
	}
	
	/**
	 * 	age增加2
	 */
	public void addAge() {
		age+=2;
	}

}
