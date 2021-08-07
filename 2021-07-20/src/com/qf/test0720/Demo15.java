package com.qf.test0720;

public class Demo15 {
	/*
	 * *输出杨辉三角
		杨辉三角如下：
		1
		1 1
		1 2 1
		1 3 3 1
		1 4 6 4 1
		……
		杨辉三角的特点：
		1. 第i 行有i 个元素
		2. 每一行的第一个元素和最后一个元素都为1
		3. 除了1 之外，每个元素的值，都等于上一行同位置的元素以及前一个元素的和。
		例如：
		1 4 6 4 1 的下一行
		1 a1 a2 a3 a4 1
		a1 = 4 + 1 = 5
		a2 = 6 + 4 = 10
		a3 = 4 + 6 = 10
		a4 = 1 + 4 = 5
		依次类推。
		要求：读入一个整数n，输出杨辉三角的前n 行
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
