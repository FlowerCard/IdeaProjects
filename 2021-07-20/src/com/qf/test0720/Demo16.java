package com.qf.test0720;

import java.util.Arrays;
import java.util.Scanner;

public class Demo16 {
	/*
	 * ����Ĳ����ɾ��
   	  ����һ������Ϊ10�����飬ͨ������̨�����룬
     1.��������ָ����λ���в���һ����Ԫ�أ�
     2.ɾ��ָ��λ�õ�Ԫ��
	 */
	public static void main(String[] args) {
		//��̬��ʼ������
		int[] numbers = new int[10];
		//Ϊ���鸳���ֵ
		Scanner sc = new Scanner(System.in);
		System.out.println("������10��������");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
		//�ӿ���̨����Ҫ�����λ�ú�����
		int len = numbers.length;
		int[] newNumbers = new int[len];
		System.out.print("������Ҫ�����λ�ã�");
		int insertPosition = sc.nextInt();
		System.out.print("������Ҫ��������֣�");
		int insertNumber = sc.nextInt();
		for (int i = 0; i < newNumbers.length; i++) {
			if(i == insertPosition-1) {
				len++;
				newNumbers[i] = insertNumber;
			}else {
				newNumbers[i] = numbers[i];
			}
			
		}
		System.out.println(Arrays.toString(newNumbers));
		
		//�ӿ���̨����Ҫɾ����λ��
		System.out.print("������Ҫɾ����λ�ã�");
		int deletePosition = sc.nextInt();
		int deletelen = len;
		int[] deleteArrs = new int[len];
		int j = 0;
		for (int i = 0; i < newNumbers.length; i++) {
			if(i == deletePosition-1) {
//				deletelen--;
//				len;
				continue;
			}else {
				deleteArrs[j] = newNumbers[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(deleteArrs));
	}
}
