package com.zjj.homework1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchDepth {

	public static void main(String[] args) {
		//作为参数
		int[] whitelist = new In(args[0]).readAllInts();
		Arrays.sort(whitelist);
		//文件作为输入
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			//输出不在白名单的值
			if(rank(key , whitelist) < 0) 
				StdOut.println(key);
		}
	}
	
	public static int rank(int key,int[] a,int lo,int hi,int depth) {
		//按照深度缩进
		for(int i = 0;i < depth;i++)
			StdOut.printf(" ");
		StdOut.println("lo="+lo+",hi="+hi);
		//值不存在于白名单
		if(lo > hi)
			return -1;
		int mid = lo + (hi - lo)/2;
		if(a[mid] > key)
			return rank(key,a,lo,mid-1,++depth);
		else if(a[mid] < key)
			return rank(key,a,mid+1,hi,++depth);
		else return mid;
	}
	
	public static int rank(int key,int a[]) {
		return rank(key,a,0,a.length-1,0);
	}

}












