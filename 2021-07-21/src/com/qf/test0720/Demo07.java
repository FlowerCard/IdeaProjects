package com.qf.test0720;

public class Demo07 {
	/*��һ����5��Ԫ����ɵ�һά������ ����һ���Ѿ�����õ����֣���������������д�Ԫ�أ�
		����ʾ������������***���֡��������������û������ʾ�������ֲ��ڴ������С�
	*/
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5};
		int searchNumber = 5;
		boolean flag = true;
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == searchNumber) {
				flag = true;
			}else {
				flag = false;
			}
		}
		
		if(flag) {
			System.out.println("����" + searchNumber + " �ڴ�������");
		}else {
			System.out.println("����" + searchNumber + " ���ڴ�������");
		}
	}
}
