package com.qf.test0720;

public class Demo02 {
	public static void main(String[] args) {
		//����һ��5��Ԫ����ɵ�һά���飬���丳ֵ���ٰѸ����鷴�����
		int[] number = new int[] {1,2,3,4,5};
		//���������������
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < number.length - i - 1; j++) {
				if(number[j+1] > number[j]) {
					int temp = number[j];
					number[j] = number[j+1];
					number[j+1] = temp;
				}
			}
		}
		//�������������
		for (int i = 0; i < number.length; i++) {
			System.out.println(number[i]);
		}
	}
}
