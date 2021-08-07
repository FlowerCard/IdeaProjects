package com.qf.test0720;

public class Demo03 {
	public static void main(String[] args) {
		//定义一个包含10个元素的数组，对其进行赋值，使每个元素的值等于其下标
		int[] numbers = new int[10];
		
		//给数组赋值
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			//输出赋值后的数组
			System.out.println(numbers[i]);
		}
		
	}
}
