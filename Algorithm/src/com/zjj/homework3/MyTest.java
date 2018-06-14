package com.zjj.homework3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MyTest {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < arr.length; i++) {
			int r = StdRandom.uniform(10);
			int temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			StdOut.print(arr[i]+",");
		}

	}

}
