package com.qf.test0720;

public class Demo12 {
	/*
	 * ���������µ�һ�����飺
		int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ;
	   Ҫ������������ֵΪ0����ȥ��������Ϊ0��ֵ����һ���µ����飬���ɵ�������Ϊ��
		int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5} ;
	  ˼·�������е������� = �����еĽ����
	 1��	ȷ������Ϊ0�ĸ������������Կ��������飻
	 2��	�Ӿɵ�����֮�У�ȡ�����ݣ������丳���¿��ٵ����飻
	 */
	public static void main(String[] args) {
		int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		int count = 0;
		for (int i = 0; i < oldArr.length; i++) {
			if(oldArr[i] != 0) {
				//ͳ��������0�ĸ���
				count++;
			}
		}
		int[] newArr = new int[count];
		int j = 0;
		for (int i = 0; i < oldArr.length; i++) {
			if(oldArr[i] != 0) {
				newArr[j] = oldArr[i];
				j++;
			}
		}
		
		//���������
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
		
	} 
}
