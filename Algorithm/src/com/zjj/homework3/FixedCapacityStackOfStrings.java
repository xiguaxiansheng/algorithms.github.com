package com.zjj.homework3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

	//实例变量
	private String[] a; //栈实体
	private int N; //size
	
	//创建指定大小的空栈
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}

	private int size() {
		
		return N;
	}
	
	//出栈
	private String pop() {	
		return a[--N];
	}
	
	//进栈
	private void push(String item) {
		a[N++]=item;
	}
	
	//是否为空栈
	private boolean isEmpty() {
		return N==0;
	}
	
	//是否满栈
	private boolean isFull() {
		return N==a.length;
	}
	
	//测试用例
		public static void main(String[] args) {
			
			FixedCapacityStackOfStrings s;
			s = new FixedCapacityStackOfStrings(100);
			
			while(!StdIn.isEmpty()) {
				
				String item = StdIn.readString();
				if(!item.equals("-"))
					s.push(item);
				else if(!s.isEmpty())
					StdOut.print(s.pop()+" ");
					
			}
			
			StdOut.println("("+s.size()+"left on stack)");
			
			if(s.isFull()) 
				StdOut.println("the stack is full");
			else
				StdOut.println("the stack isn't full");
		}

}
