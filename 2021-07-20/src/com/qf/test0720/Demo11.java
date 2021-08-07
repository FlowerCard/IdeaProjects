package com.qf.test0720;

public class Demo11 {
	//静态初始化二维数组 {{1}，{2，3}，{4，5，6}}，输出每个元素的值
	public static void main(String[] args) {
		int[][] numbers = new int[][] {
				{1},{2,3},{4,5,6}
		};
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.println(numbers[i][j]);
			}
		}
	}
}
