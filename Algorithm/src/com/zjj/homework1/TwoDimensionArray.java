package com.zjj.homework1;

import edu.princeton.cs.algs4.StdOut;

public class TwoDimensionArray {

	// 打印二维数组
	public static void main(String[] args) {

		boolean[][] arr = { { false, true, true, true }, { true, false, false, true }, { true, true, true, false },
				{ false, false, true, true } };
		printArray(arr);
	}

	public static void printArray(boolean[][] arr) {

		// 输入列号
		StdOut.print(" ");
		for (int k = 0; k < arr[0].length; k++)
			StdOut.print(k);
		StdOut.print('\n');

		for (int i = 0; i < arr.length; i++) {
			// 输入行号
			StdOut.print(i);
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == true)
					StdOut.print("*");
				else
					StdOut.print(" ");
			}
			StdOut.print('\n');
		}
	}

}
