package com.zjj.homework3;

import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//输入后序表达式，得到结果
//思路：遇到符号，pop出前两个值进行运算得到结果，最后push结果
public class EvaluatePostfix {

	public static void main(String[] args) {

		Stack<Double> data = new Stack<Double>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			
			if(IsSign(item)) {
				Double data1 = data.pop();
				Double data2 = data.pop();
				switch(item){
				case "+":
					data.push(data2+data1);
					break;
				case "-":
					data.push(data2-data1);
					break;
				case "*":
					data.push(data2*data1);
					break;
				case "/":
					data.push(data2/data1);
					break;
				}
		}else {
			data.push(Double.parseDouble(item));//字符串转换成Double类型，压入data
		}
	}
		StdOut.print(data.pop());

}

	private static boolean IsSign(String item) {
		if(item.equals("+")||item.equals("-")||item.equals("*")||item.equals("/"))
			return true;
		return false;
	}
	
}	
	
	

