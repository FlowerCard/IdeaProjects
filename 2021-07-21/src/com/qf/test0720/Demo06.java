package com.qf.test0720;

import java.util.Scanner;

public class Demo06 {
	//��һ����5��Ԫ����ɵ�һά������ ����һ�����֡�5������������������д�Ԫ�أ�����ʾ������5�ڴ������С�
	public static void main(String[] args) {
		int[] numbers = new int[] {1,2,3,4,5};
		int searchNumber = 0;
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		System.out.print("������Ҫ���ҵ����֣�");
		searchNumber = scanner.nextInt();
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
