package com.qf.test0720;

public class Demo02 {
	public static void main(String[] args) {
		//定义一个5个元素组成的一维数组，对其赋值，再把该数组反向输出
		int[] number = new int[] {1,2,3,4,5};
		//反向排序定义的数组
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number.length - i - 1; j++) {
				if(number[j+1] > number[j]) {
					int temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
				}
			}
		}
		//输出排序后的数组
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
	}
}
