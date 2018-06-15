package com.zjj.homework1;

import edu.princeton.cs.algs4.StdOut;

public class Euclid {

	public static void main(String[] args) {
		
		StdOut.println("result:"+euclid(6,-5));
		//StdOut.println("result:"+euclid(1111111,1234567));
	}
	
	public static int euclid(int p,int q) {
		//输出p,q的值
		StdOut.println("p="+p+","+"q="+q);
		//欧几里得算法求最大公约数
		if(q==0)
			return p;
		return euclid(q,p % q);
	}

}
