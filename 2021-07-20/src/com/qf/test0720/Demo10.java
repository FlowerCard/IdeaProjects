package com.qf.test0720;

public class Demo10 {
	//静态初始化一维数组{10，20，11，35，6,89}，进行冒泡排序
	public static void main(String[] args) {
		int[] numbers = new int[] {10,20,11,35,6,89};
		
		//冒泡排序
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j+1] < numbers[j]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		//输出数组
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}
