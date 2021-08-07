package com.qf.test0720;

public class Demo04 {
	//定义一个10个元素组成的一维数组，求该数组中的最大值和最小值。及最大值和最小值的平均值 
	public static void main(String[] args) {
		int[] numbers = new int[10];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		//对数组进行赋值
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*100);
		}
		//对数组取最大最小值
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}
		System.out.println("max:" + max + ",min:" + min);
		System.out.println("avg:" + (max+min)/2);
	}
}
