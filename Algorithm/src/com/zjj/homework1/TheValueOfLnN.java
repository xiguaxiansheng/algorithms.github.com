package com.zjj.homework1;

import edu.princeton.cs.algs4.StdOut;

public class TheValueOfLnN {

	public static void main(String[] args) {
	
		StdOut.print(ln(10));
	}
	
	//计算ln(N!)的值
	public static double ln(int N) {
		if(N==0)
			return 0;
		else
			return Math.log(N)+ln(N-1);
	}

}
