package com.zjj.homework1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class CompareThreeParm {

	public static void main(String[] args) {
		// 输入三个数
		StdOut.println("请输入前两个：");
		int parm1 = StdIn.readInt();
		int parm2 = StdIn.readInt();
		// 比较,判断是否有必要输入第三个数
		if (parm1 == parm2) {
			StdOut.println("请输入第三个数");
			int parm3 = StdIn.readInt();
			if (parm2 == parm3) {
				StdOut.println("equal");
			} else {
				StdOut.println("not equal");
			}
		} else {
			StdOut.println("not equal");
		}

	}

}
