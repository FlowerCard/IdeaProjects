package com.qf.test0720;

import java.util.Scanner;

public class Demo06 {
	//在一个由5个元素组成的一维数组中 查找一个数字‘5’，如果该有数组中有此元素，由提示“数字5在此数组中”
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5};
		int searchNumber = 0;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入要查找的数字：");
		searchNumber = scanner.nextInt();
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == searchNumber) {
				flag = true;
			}else {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("数字" + searchNumber + " 在此数组中");
		}else {
			System.out.println("数字" + searchNumber + " 不在此数组中");
		}
	}
}
