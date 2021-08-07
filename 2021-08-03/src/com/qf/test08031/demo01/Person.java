package com.qf.test08031.demo01;

public class Person  implements Comparable{//
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		if (this.age != person.age)	return false;
		if (this.name == null) {
			if (person.name != null) {
				return false;
			}
		} else if (!this.name.equals(person.name)) {
			return true;
		}
		return true;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person person = (Person) o;
			int a = this.name.compareTo(person.name);
			if (a == 0) {
				return this.age - person.age;
			}
			return a;
		}
		return 0;
	}
}
