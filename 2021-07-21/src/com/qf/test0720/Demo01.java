package com.qf.test0720;

import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		int stuNumber = 0;
		int[] scores = new int[stuNumber];
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入学生人数：");
		stuNumber = scanner.nextInt();
		System.out.println("请输入"+ stuNumber +"个成绩");
		
		//记录最大值
		int max = Integer.MIN_VALUE;
		//循环输入5个成绩
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scanner.nextInt();
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		//输出最高分
		System.out.println("最高分是：" + max);
		//输出每个学生的评级和分数
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= max - 10) {
				System.out.println("student " + i + " score is " + scores[i] + " grade is A");
			}else if (scores[i] >= max - 20) {
				System.out.println("student " + i + " score is " + scores[i] + " grade is B");
			}else if (scores[i] >= max - 30) {
				System.out.println("student " + i + " score is " + scores[i] + " grade is C");
			}else {
				System.out.println("student " + i + " score is " + scores[i] + " grade is D");
			}
		}
	}
}
