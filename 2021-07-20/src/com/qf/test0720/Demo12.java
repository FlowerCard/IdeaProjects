package com.qf.test0720;

public class Demo12 {
	/*
	 * 现在有如下的一个数组：
		int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ;
	   要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：
		int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5} ;
	  思路：生活中的问题解决 = 程序中的解决；
	 1、	确定出不为0的个数，这样可以开辟新数组；
	 2、	从旧的数组之中，取出内容，并将其赋给新开辟的数组；
	 */
	public static void main(String[] args) {
		int[] oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		int count = 0;
		for (int i = 0; i < oldArr.length; i++) {
			if(oldArr[i] != 0) {
				//统计数组中0的个数
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
		
		//输出新数组
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
		
	} 
}
