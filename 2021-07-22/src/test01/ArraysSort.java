package test01;

import java.util.*;

/**
 * 	���鹤����
 * @author HuaPai
 *
 */
public class ArraysSort {
	
	/**
	 * 	�������ֵ
	 * @param a ���������
	 * @return	�������ֵ
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
	 * 	������Сֵ
	 * @param a	���������
	 * @return	������Сֵ
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
	 * 	������������
	 * @param a	���������
	 * @return	��������������
	 */
	public int[] sortArrays(int[] a) {
		Arrays.sort(a);
		return a;
	}
	
	/**
	 * 	�������������һ���Ϊһ�������飬����ƽ��ֵ
	 * @param a �����һ������
	 * @param b	����ڶ�������
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
	 * 	�������Ƿ���9
	 * @param a ���������
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
