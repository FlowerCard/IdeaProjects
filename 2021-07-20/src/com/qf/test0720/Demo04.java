package com.qf.test0720;

public class Demo04 {
	//����һ��10��Ԫ����ɵ�һά���飬��������е����ֵ����Сֵ�������ֵ����Сֵ��ƽ��ֵ 
	public static void main(String[] args) {
		int[] numbers = new int[10];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		//��������и�ֵ
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*100);
		}
		//������ȡ�����Сֵ
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
