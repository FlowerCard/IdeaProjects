package com.qf.test0720;

public class Demo03 {
	public static void main(String[] args) {
		//����һ������10��Ԫ�ص����飬������и�ֵ��ʹÿ��Ԫ�ص�ֵ�������±�
		int[] numbers = new int[10];
		
		//�����鸳ֵ
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			//�����ֵ�������
			System.out.println(numbers[i]);
		}
		
	}
}
