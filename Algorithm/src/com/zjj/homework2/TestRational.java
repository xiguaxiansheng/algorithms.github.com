package com.zjj.homework2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//Rational的测试用例
public class TestRational {

	public static void main(String[] args) {

		//有理数计算测试用例
		//long rn = StdIn.readLong();
		//long rd = StdIn.readLong();
		//Rational r = new Rational(rn, rd);
		//StdOut.println(r);
		//long bn = StdIn.readLong();
		//long bd = StdIn.readLong();
		//Rational b = new Rational(bn, bd);
		//StdOut.println(b);
		//StdOut.println("a plus b = " + r.plus(b));
		//StdOut.println("a minus b = " + r.minus(b));
		//StdOut.println("a times b = " + r.times(b));
		//StdOut.println("a divides b = " + r.divides(b));

		// 防止溢出測試用例，需要配置参数-ea，才能是断言生效
		Rational r0 = new Rational(1, 1000000000);
		Rational r1 = new Rational(1, 1000000001);
		Rational r2 = new Rational(1, 1000000002);
		StdOut.print(r0.plus(r1).plus(r2));
	}

}
