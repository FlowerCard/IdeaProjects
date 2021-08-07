package com.qf.test0720;import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo13 {
	/*
	 * 现在给出两个数组：
	· 数组A：{1，7，9，11，13，15，17，19}
	· 数组b：{2，4，6，8，10}
      两个数组合并为数组c，按升序排列。
	主要的目的是熟悉这两个操作的方法，数组扩大，必须要将原始数组的内容拷贝进去。

	 */
	public static void main(String[] args) {
		int[] a = new int[]{1,7,9,11,13,15,17,19};
		int[] b = new int[]{2,4,6,8,10};
		int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		System.out.println(Arrays.toString(c));
	}
}
