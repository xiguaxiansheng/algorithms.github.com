package com.zjj.homework1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SmallerThanLogN {

	public static void main(String[] args) {
		
		int N = StdIn.readInt();
		StdOut.print(lg(N));
	}
	
	//返回不大于log2N的数,也可以用移位运算  N >>= 1
	//移位运算，就是把数化为二进制进行>>表示右移动，<<表示左移动
	public static int lg(int N) {
		int maxNum = 0;
		for (int i = N; i >= 2; i /= 2) {
			maxNum++;
		}
		return maxNum;
	}
	
	

}
