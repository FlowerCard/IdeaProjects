package com.qf.test0720;

public class Demo09 {
	/*
	 * ��һ����������������ת�������
	���磺	Դ���飬1 2 3 4 5 6
			ת��֮������飬6 5 4 3 2 1
	 */
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5,6};
		//ת������
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length -i - 1; j++) {
				if (numbers[j+1] > numbers[j]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		//�������
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
	}
}
