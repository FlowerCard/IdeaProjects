package com.qf.test0720;

public class Demo08 {
	//7	��һ����10��Ԫ����ɵ�һά�����У�����Ԫ�ص�ƽ��ֵ
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
