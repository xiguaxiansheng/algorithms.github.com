package com.zjj.homework1;

import edu.princeton.cs.algs4.StdOut;

public class HistogramTest {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 6, 5, 4, 4, 0, 1 };
		int[] arr = histogram(a, 7);
		// 如果a中的值均在0-7之中，arr的和=a.length
		StdOut.println(ArraySum(arr));
		StdOut.println(a.length);

	}

	public static int[] histogram(int[] a, int M) {
		int[] arr = new int[M];
		// 初始化数组arr为0
		// for(int i= 0;i<M-1;i++)
		// arr[i]=0;
		// 第i个元素的值为整数 i在a中出现的次数
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0 && a[i] < M)
				arr[a[i]]++;
		}
		return arr;
	}

	public static int ArraySum(int[] arr) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum = sum + arr[i];
		return sum;
	}

}
