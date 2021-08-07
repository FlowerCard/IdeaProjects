package com.qf.test0720;

public class Demo07 {
	/*在一个由5个元素组成的一维数组中 查找一个已经定义好的数字，如果该有数组中有此元素，
		由提示“此数组中有***数字”，如果此数组中没有则提示“该数字不在此数组中”
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
			System.out.println("数字" + searchNumber + " 在此数组中");
		}else {
			System.out.println("数字" + searchNumber + " 不在此数组中");
		}
	}
}
