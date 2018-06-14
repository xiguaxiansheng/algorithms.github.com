package com.zjj.homework1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RelativelyPrimeArray {

	public static void main(String[] args) {
		
		int N = StdIn.readInt();
		boolean[][] arr = new boolean[N][N];
		RelativelyPrime(arr);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				StdOut.print(arr[i][j] + " ");
			StdOut.println("");
		}
		
	}

	private static void RelativelyPrime(boolean[][] arr) {

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
					if(euclid(i,j)==1 || i==0 || j==0)
						arr[i][j]=true;
					else
						arr[i][j]=false;
			}
	}

	public static int euclid(int p, int q) {
		// 欧几里得算法求最大公约数
		if (q == 0)
			return p;
		return euclid(q, p % q);
	}
}
