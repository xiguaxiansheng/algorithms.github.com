package com.zjj.homework3;

import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class FillLeftBrackets {

	public static void main(String[] args) {
		
		//存储数字符号，和拼凑成的完整括号字段
		Stack<String> data = new Stack<String>();
		//文件作为输入,在Eclipse 中 Ctrl+Z表示输入结束
		while(!StdIn.isEmpty()) {
			String item = StdIn.readString();
			//遇到右括号，拿出两数字或完整的括号字段，拼凑成新的完整的括号字段压入data
			if(item.equals(")")) {
				String data1 = data.pop();
				String sign = data.pop(); //符号
				String data2 = data.pop();
				data.push("("+data2+sign+data1+")");
			}else {
				data.push(item);
			}
		}	
		//输出最终的完整括号字段
		StdOut.print(data.pop());
	}
	
}
