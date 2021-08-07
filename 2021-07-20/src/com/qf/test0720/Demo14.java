package com.qf.test0720;

import java.util.Arrays;

public class Demo14 {
	//静态初始化二维数组 {{11，15，32，21}，{2，3}，{4，5，6}}，输出每个元素的值，并从小到大排序
	public static void main(String[] args) {
		int[][] numbers = new int[][] {
			{11,15,32,21},{2,3},{4,5,6}
		};
		int[] newArr = new int[9];
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				newArr[index] = numbers[i][j];
				index++;
			}
		}
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr.length - i - 1; j++) {
				if(newArr[j+1] < newArr[j]) {
					int temp = newArr[j+1];
					newArr[j+1] = newArr[j];
					newArr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(newArr));
	}
}
