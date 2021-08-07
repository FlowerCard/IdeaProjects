package com.qf.test0720;

public class UseStudent {
	public static void main(String[] args) {
		Student[] students = new Student[20];
		int number = 0;
		int state = 0;
		int score = 0;
		for (int i = 0; i < students.length; i++) {
			number = (int)(Math.random()*20+1);
			state = (int)(Math.random()*3+1);
			score = (int)(Math.random()*100);
			students[i] = new Student(number,state,score);
		}
		
		for (int i = 0; i < students.length; i++) {
			if(students[i].state == 3) {
				System.out.println(students[i].number + "," + students[i].state + "," + students[i].score);
			}
		}
	}
}
