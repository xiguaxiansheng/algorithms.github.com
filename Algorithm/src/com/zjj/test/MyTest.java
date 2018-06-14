
package com.zjj.test;

import edu.princeton.cs.algs4.StdOut;

public class MyTest {
	
	
	public static void main(String[] args) {
		
		//数组别名测试
		int[] a= new int[4];
		a[0] = 1234;
		int[]b = a;
		b[0] =5678;
		StdOut.println(a[0]);
		StdOut.println(b[0]);
		//数学函数测试
		System.out.println(Math.sqrt(4.0));
		//测试格式化输出
		//%
		//.3f,表示小数点后3位的浮点数
		//12,-14，表示要以多少字符显示
		System.out.printf("PI is approximately %.3f\n", Math.PI);
		System.out.printf("%12s\n","Hello,world");
		System.out.printf("%-14s\n","Hello,world");
		System.out.printf("%-14.5s\n","Hello,world");
	}

}
