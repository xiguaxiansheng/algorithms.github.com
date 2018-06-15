package com.zjj.homework3;

import java.util.Iterator;
import java.util.Stack;

import edu.princeton.cs.algs4.StdOut;

public class StackCopy {

	public static void main(String[] args) {
		
		Stack<String> s1 = new Stack<String>();
		s1.push("to");
		s1.push("be");
		s1.push("or");
		Stack<String> s2 = copy(s1);
		StdOut.println(s2.pop());
		StdOut.println(s2.pop());
		StdOut.println(s2.pop());
	}

	//栈为先进后出，所以需要数据迁移两次
	private static Stack<String> copy(Stack<String> s) {
		Iterator<String> i = s.iterator();
		Stack<String> temp = new Stack<String>();
		Stack<String> ss = new Stack<String>();
		while(i.hasNext()) {
			temp.push(i.next());
		}
		i = temp.iterator();
		while(i.hasNext()) {
			ss.push(i.next());
		}
		return ss;
	}

}




