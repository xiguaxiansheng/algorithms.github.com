package com.zjj.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {

	public static void main(String[] args) {
		String[] a =  new In(args[0]).readAllStrings();
		show(a);
		sort(a);
		assert isSort(a);
		show(a);

	}

	// 选择排序实现
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		// 将a[]按升序排列
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))min = j;
			}
			//每次选出最小的放在有序区
			exch(a, i, min);
		}
	}

	// 将元素交换位置
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int j, int min) {

		Comparable t = a[j];
		a[j] = a[min];
		a[min] = t;

	}

	// 对元素进行比较
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {

		return v.compareTo(w) < 0;
	}

	// 打印数据
	@SuppressWarnings("rawtypes")
	private static void show(Comparable[] a) {

		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();

	}

	// 判断时候有序
	@SuppressWarnings("rawtypes")
	private static boolean isSort(Comparable[] a) {

		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1]))
				return false;

		return true;
	}

}
