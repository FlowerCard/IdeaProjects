package com.qf.test0720;import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo13 {
	/*
	 * ���ڸ����������飺
	�� ����A��{1��7��9��11��13��15��17��19}
	�� ����b��{2��4��6��8��10}
      ��������ϲ�Ϊ����c�����������С�
	��Ҫ��Ŀ������Ϥ�����������ķ������������󣬱���Ҫ��ԭʼ��������ݿ�����ȥ��

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
