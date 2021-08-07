package com.qf.test0720;

public class Demo05 {
	//义一个10个元素组成的一维数组，求该数组中的最大值，以及最大值在该数组中的位置
	public static void main(String[] args) {
		int[] numbers = new int[10];
		int max = Integer.MIN_VALUE;
		//随机为数组填入数据
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*100);
		}
		//取出最大值
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		System.out.println("max:" + max);
		
		//输出最大值的位置
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == max) {
				System.out.println(i);
			}
		} 
	}

}
