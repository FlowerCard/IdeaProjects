package com.qf.test0720;

public class Demo05 {
	//��һ��10��Ԫ����ɵ�һά���飬��������е����ֵ���Լ����ֵ�ڸ������е�λ��
	public static void main(String[] args) {
		int[] numbers = new int[10];
		int max = Integer.MIN_VALUE;
		//���Ϊ������������
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*100);
		}
		//ȡ�����ֵ
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		System.out.println("max:" + max);
		
		//������ֵ��λ��
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == max) {
				System.out.println(i);
			}
		} 
	}

}
