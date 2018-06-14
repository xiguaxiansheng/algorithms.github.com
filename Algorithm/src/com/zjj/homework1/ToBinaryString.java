package com.zjj.homework1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//正整数转换为二进制字符串
public class ToBinaryString {

	public static void main(String[] args) {

		int N = StdIn.readInt();
		String s = "";
		for (int n = N; n > 0; n /= 2)
			s = (n % 2) + s;
		StdOut.println(s);
	}

}
