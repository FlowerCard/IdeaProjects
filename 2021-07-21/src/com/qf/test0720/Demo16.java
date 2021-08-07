package com.qf.test0720;

import java.util.Arrays;
import java.util.Scanner;

public class Demo16 {
	/*
	 * 数组的插入和删除
   	  定义一个长度为10的数组，通过控制台的输入，
     1.向数组中指定的位置中插入一个新元素，
     2.删除指定位置的元素
	 */
	public static void main(String[] args) {
		//动态初始化数组
		int[] numbers = new int[10];
		//为数组赋入初值
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入10个整数：");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		//从控制台输入要插入的位置和数字
		int len = numbers.length;
		int[] newNumbers = new int[len];
		System.out.print("请输入要插入的位置：");
		int insertPosition = sc.nextInt();
		System.out.print("请输入要插入的数字：");
		int insertNumber = sc.nextInt();
		for (int i = 0; i < newNumbers.length; i++) {
			if(i == insertPosition-1) {
				len++;
				newNumbers[i] = insertNumber;
			}else {
				newNumbers[i] = numbers[i];
			}
			
		}
		System.out.println(Arrays.toString(newNumbers));
		
		//从控制台输入要删除的位置
		System.out.print("请输入要删除的位置：");
		int deletePosition = sc.nextInt();
		int deletelen = len;
		int[] deleteArrs = new int[len];
		int j = 0;
		for (int i = 0; i < newNumbers.length; i++) {
			if(i == deletePosition-1) {
//				deletelen--;
//				len;
				continue;
			}else {
				deleteArrs[j] = newNumbers[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(deleteArrs));
	}
}
