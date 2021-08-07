package com.qf.test0720;

public class Demo08 {
	//7	求一个由10个元素组成的一维数组中，所有元素的平均值
	public static void main(String[] args) {
		int[] numbers = new int[10];
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*100);
			sum += numbers[i];
		}
		System.out.println("avg:" + sum/numbers.length);
	}
}
