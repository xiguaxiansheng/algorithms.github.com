package com.zjj.data;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestVisualAccumulator {

	//测试用例
	public static void main(String[] args) {
		
		int T = Integer.parseInt(args[0]);
		VisualAccumulator a = new VisualAccumulator(T,1.0);
		for(int t = 0;t < T;t++)
			a.addDataValue(StdRandom.random());//取0到1之间的数
		StdOut.print(a);

	}

}
