package com.qf.test0720;

public class Demo15 {
	/*
	 * *����������
		����������£�
		1
		1 1
		1 2 1
		1 3 3 1
		1 4 6 4 1
		����
		������ǵ��ص㣺
		1. ��i ����i ��Ԫ��
		2. ÿһ�еĵ�һ��Ԫ�غ����һ��Ԫ�ض�Ϊ1
		3. ����1 ֮�⣬ÿ��Ԫ�ص�ֵ����������һ��ͬλ�õ�Ԫ���Լ�ǰһ��Ԫ�صĺ͡�
		���磺
		1 4 6 4 1 ����һ��
		1 a1 a2 a3 a4 1
		a1 = 4 + 1 = 5
		a2 = 6 + 4 = 10
		a3 = 4 + 6 = 10
		a4 = 1 + 4 = 5
		�������ơ�
		Ҫ�󣺶���һ������n�����������ǵ�ǰn ��
	 */
	public static void main(String[] args) {
		int[][] a = new int[5][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[i+1];
			for (int j = 0; j < a[i].length; j++) {
				if(j == 0 || j == i) {
					a[i][j] = 1;
				}else {
					a[i][j] = a[i-1][j] + a[i-1][j-1];
				}
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
