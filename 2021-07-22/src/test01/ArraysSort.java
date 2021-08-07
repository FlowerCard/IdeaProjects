package test01;

import java.util.*;

/**
 * 	数组工具类
 * @author HuaPai
 *
 */
public class ArraysSort {
	
	/**
	 * 	数组最大值
	 * @param a 传入的数组
	 * @return	返回最大值
	 */
	public int maxArrays(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	/**
	 * 	数组最小值
	 * @param a	传入的数组
	 * @return	返回最小值
	 */
	public int minArrays(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}
	
	/**
	 * 	数组升序排列
	 * @param a	传入的数组
	 * @return	返回排序后的数组
	 */
	public int[] sortArrays(int[] a) {
		Arrays.sort(a);
		return a;
	}
	
	/**
	 * 	两个数组组合在一起成为一个新数组，并求平均值
	 * @param a 传入第一个数组
	 * @param b	传入第二个数组
	 * @return
	 */
	public double avgArrays(int[] a,int[] b) {
		double avg = 0.0;
		double sum = 0.0;
		int[] c = new int[a.length+b.length];
		Arrays.sort(a);
		Arrays.sort(b);
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		for (int i = 0; i < c.length; i++) {
			sum += c[i];
		}
		avg = sum / c.length;
		return avg;
	}
	
	/**
	 * 	数组内是否含有9
	 * @param a 传入的数组
	 * @return
	 */
	public boolean haveArrays(int[] a) {
		boolean flag = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 9) {
				flag = true;
			}
		}
		return flag;
	}
	
	
}
