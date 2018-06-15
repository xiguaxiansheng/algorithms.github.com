package com.zjj.homework1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchOutput {

	public static void main(String[] args) {

		// 系统变量输入'+'或者'-'
		String sign = args[1];
		// 文件作为参数
		int[] whitelist = new In(args[0]).readAllInts();
		Arrays.sort(whitelist);
		// 文件作为输入
		while (!StdIn.isEmpty()) {

			int key = StdIn.readInt();
			if (sign.equals("+")) {
				if (rank(key, whitelist) < 0)
					StdOut.printf("%d ", key);
				
			} else if (sign.equals("-")) {
				if (rank(key, whitelist) >= 0)
					StdOut.printf("%d ", key);
			}
		}
	}

	// 二分查找递归实现
	public static int rank(int key, int[] a, int lo, int hi) {

		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (a[mid] > key)
			return rank(key, a, lo, mid - 1);
		else if (a[mid] < key)
			return rank(key, a, mid + 1, hi);
		else
			return mid;//返回值范围：（0~a.length-1）

	}

	public static int rank(int key, int[] a) {

		return rank(key, a, 0, a.length - 1);
	}

}
