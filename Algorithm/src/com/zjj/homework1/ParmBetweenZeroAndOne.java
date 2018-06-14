package com.zjj.homework1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ParmBetweenZeroAndOne {

	public static void main(String[] args) {

		Double x = StdIn.readDouble();
		Double y = StdIn.readDouble();
		
		if (isTrue(x) && isTrue(y))
			StdOut.print("true");
		else
			StdOut.print("false");
	}

	public static boolean isTrue(Double x) {
		if (x > 0 && x < 1)
			return true;
		else
			return false;
	}

}
