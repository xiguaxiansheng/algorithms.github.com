package com.zjj.homework1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StatisticalTable {

	public static void main(String[] args) {

		StdOut.print("please input the number of the count:");
		int n = StdIn.readInt();
		// 姓名
		String[] names = new String[n];
		// 数学语文成绩
		int[] math = new int[n];
		int[] chinese = new int[n];
		// 输入数据
		for (int i = 0; i < n; i++) {
			names[i] = StdIn.readString();
			chinese[i] = StdIn.readInt();
			math[i] = StdIn.readInt();
		}
		
		StdOut.printf("|%4s|%4s|%4s|%6s|\n", "姓名", "语文", "数学", "语文/数学");
		
		//23=format中的总长度
		for (int i = 0; i < 23; i++)
			StdOut.print("=");
		StdOut.println("");
		
		//s表示字符串，d表示整数，f表示浮点数
		for (int j = 0; j < n; j++) {
			StdOut.printf("|%4s|%4d|%4d|%6.3f|\n", names[j], chinese[j], math[j], (float) chinese[j] / math[j]);
		}
		
		for (int i = 0; i < 23; i++)
			StdOut.print("=");
		

	}

}
