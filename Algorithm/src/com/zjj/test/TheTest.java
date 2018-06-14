package com.zjj.test;

import edu.princeton.cs.algs4.StdIn;

public class TheTest {


	      
	    public static void main(String[] args)  
	    {  
	        Rational r = new Rational(2, -6);  
	        System.out.println(r);  
	        Rational r1 = new Rational(1, 5);  
	        Rational r2 = new Rational(-1, 15);  
	        System.out.println(r.plus(r1));  
	        System.out.println(r.plus(r2).plus(r1));  
	        System.out.println(r.minus(r1));  
	        System.out.println(r.times(r1));  
	        System.out.println(r.divides(r1));  
	        System.out.println(r.times(r1).equals(r2));  
	        r = new Rational(0, 2);  
	        System.out.println(r);  
	        System.out.println(r.plus(r1));  
	          
	        r1 = new Rational(1, 3);  
	        r2 = new Rational(2, 3);  
	        System.out.println(r1.plus(r2));  
	          
	        r1 = new Rational(1, 200000000);  
	        r2 = new Rational(1, 300000000);  
	        System.out.println(r1.plus(r2));  
	          
	        r1 = new Rational(1073741789, 20);  
	        r2 = new Rational(1073741789, 30);  
	        System.out.println(r1.plus(r2));  
	          
	          
	    }  
	}  
	  
	class Rational  
	{  
	    private final long num;  
	    private final long den;  
	      
	    public Rational(long numerator, long denominator)  
	    {  
	        if (denominator == 0)  
	            throw new RuntimeException("Denominator is zero");  
	        long g = gcd(numerator, denominator);  
	          
	        if (denominator < 0)  
	            g = -g;  
	          
	        this.num = numerator / g;  
	        this.den = denominator / g;  
	    }  
	      
	    public Rational plus(Rational b)  
	    {  
	        long d = den * b.den;  
	        long n = num * b.den + den * b.num;  
	        return new Rational(n, d);  
	    }  
	      
	    public Rational minus(Rational b)  
	    {  
	        long d = den * b.den;  
	        long n = num * b.den - den * b.num;  
	        return new Rational(n, d);  
	    }  
	      
	    public Rational times(Rational b)  
	    {  
	        return new Rational(num * b.num, den * b.den);  
	    }  
	      
	    public Rational divides(Rational b)  
	    {  
	        return new Rational(num * b.den, den * b.num);  
	    }  
	      
	    public boolean equals(Rational that)  
	    {  
	        if (this == that) return true;  
	        if (that == null) return false;  
	        if (this.getClass() != that.getClass()) return false;  
	        return (num == that.num && den == that.den);   
	    }  
	      
	    private static long gcd(long m, long n)  
	    {  
	        if (m < 0) m = -m;  
	        if (n < 0) n = -n;  
	        if (n == 0) return m;  
	        return gcd(n, m % n);  
	    }  
	      
	    public String toString()  
	    {  
	        if (this.den == 1)  
	            return String.format("%d", this.num);  
	        return String.format("%d/%d", this.num, this.den);  
	    }  
	      
	}  
















