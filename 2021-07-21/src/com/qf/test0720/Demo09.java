package com.qf.test0720;

public class Demo09 {
	/*
	 * 将一个给定的整型数组转置输出，
	例如：	源数组，1 2 3 4 5 6
			转置之后的数组，6 5 4 3 2 1
	 */
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,6};
		//转置数组
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length -i - 1; j++) {
				if (numbers[j+1] > numbers[j]) {
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
