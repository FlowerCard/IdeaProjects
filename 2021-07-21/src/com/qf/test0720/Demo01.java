package com.qf.test0720;

import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		int stuNumber = 0;
		int[] scores = new int[stuNumber];
		Scanner scanner = new Scanner(System.in);
		System.out.print("������ѧ��������");
		stuNumber = scanner.nextInt();
		System.out.println("������"+ stuNumber +"���ɼ�");
		
		//��¼���ֵ
		int max = Integer.MIN_VALUE;
		//ѭ������5���ɼ�
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scanner.nextInt();
			if (scores[i] > max) {
				max = scores[i];
			}
		}
		//�����߷�
		System.out.println("��߷��ǣ�" + max);
		//���ÿ��ѧ���������ͷ���
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= max - 10) {
				System.out.println("student " + i + " score is " + scores[i] + " grade is A");
			}else if (scores[i] >= max - 20) {
				System.out.println("student " + i + " score is " + scores[i] + " grade is B");
			}else if (scores[i] >= max - 30) {
				System.out.println("student " + i + " score is " + scores[i] + " grade is C");
			}else {
				System.out.println("student " + i + " score is " + scores[i] + " grade is D");
			}
		}
	}
}
