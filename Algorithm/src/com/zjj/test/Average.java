package com.zjj.test;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {

	public static void main(String[] args) {
		double sum = 0.0;
		int cit = 0;
		//运行程序后，用ctrl+z结束输入，isEmpty判断是否输入结束
		while(!StdIn.isEmpty()) {
			sum += StdIn.readDouble();
			cit++;
		}
		double avg = sum / cit;
		StdOut.printf("Average is %.5f\n",avg);

	}

}
