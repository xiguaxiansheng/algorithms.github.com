package com.zjj.homework3;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix {

	public static void main(String[] args) {
		
		Stack<String> data = new Stack<String>(); 
		
		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			//遇到")"重新排序成：左值+右值+符号
			if(item.equals(")")) {
				String data1 = data.pop();
				String sign = data.pop();
				String data2 = data.pop();
				data.push(data2+data1+sign);
			}else if(!item.equals("(")) {
				data.push(item);
			}
		}
		StdOut.print(data.pop());

	}

}
