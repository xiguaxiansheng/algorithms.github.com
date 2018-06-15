// 二分查找学习
// Authro：zjj
package com.zjj.search;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;




public class BinarySearch {
	
	//二分查找静态方法
	public static int rank(int key,int[] a) {
		
		int lo = 0;
		int hi = a.length - 1 ;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(key < a[mid])hi = mid - 1;
			else if(key > a[mid])lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		//文件作为参数
		int[] whitelist = new In(args[0]).readAllInts();
		Arrays.sort(whitelist);
		//文件作为输入
		while(!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			//输出不在白名单的值
			if(rank(key , whitelist) < 0) 
				StdOut.print(key);
		}
	}

}
