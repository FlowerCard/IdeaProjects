package com.qf.test0720;

public class Demo10 {
	//��̬��ʼ��һά����{10��20��11��35��6,89}������ð������
	public static void main(String[] args) {
		int[] numbers = new int[] {10,20,11,35,6,89};
		
		//ð������
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j+1] < numbers[j]) {
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
