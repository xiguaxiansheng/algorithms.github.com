package com.zjj.homework2;

public class Rational {

	 private long num;
	 private long den;

	// 构造函数处理分子分母
	public Rational(long numerator, long denominator) {
		// 分母不能为0，为0抛出运算异常
		if (denominator == 0)
			throw new ArithmeticException("denominator can't be zero");
		//求公因数
		long common = gcd(denominator,numerator);
		// 负负得正，负正得负
		if (denominator < 0) common = -common;
		// 约分
		this.num = numerator / common;
		this.den = denominator / common;
	}

	// 欧几里算法求公因数
	public long gcd(long p, long q) {
		
		//处理成正数
		if(p < 0)p = -p;
		if(q < 0)q = -q;
		//算法开始
		if (q == 0)
			return p;
		long r = p % q;
		return gcd(q, r);
	}

	// 分数相加，分母=分母*分母，分子=分子*另一个分母+另一个分子*分母
	public Rational plus(Rational b) {
		
		//断言防止溢出
		assert(this.den < Integer.MAX_VALUE && this.den > Integer.MIN_VALUE);  
		assert(b.den < Integer.MAX_VALUE && b.den > Integer.MIN_VALUE);
		
		long d = this.den * b.den;
		long n = this.num * b.den + this.den * b.num;
		return new Rational(n,d);
	}
	//减法
	public Rational minus(Rational b) {
		
		//断言防止溢出
		assert(this.den < Integer.MAX_VALUE && this.den > Integer.MIN_VALUE);  
		assert(b.den < Integer.MAX_VALUE && b.den > Integer.MIN_VALUE);
		
		long d = this.den * b.den;
		long n = this.num * b.den - this.den * b.num;
		return new Rational(n,d);
	}
	
	//乘法
	public Rational times(Rational b) {
		//断言防止溢出
		assert(this.den < Integer.MAX_VALUE && this.den > Integer.MIN_VALUE);  
		assert(b.den < Integer.MAX_VALUE && b.den > Integer.MIN_VALUE);
		
		long d = this.den * b.den;
		long n = this.num * b.num;
		return new Rational(n,d);
	}
	//除法
	public Rational divides(Rational b) {
		//断言防止溢出
		assert(this.den < Integer.MAX_VALUE && this.den > Integer.MIN_VALUE);  
		assert(b.den < Integer.MAX_VALUE && b.den > Integer.MIN_VALUE);
		
		long d = this.den * b.num;
		long n = this.num * b.den;
		return new Rational(n,d);
	}
	
	public boolean equals(Rational b) {
		if(this == b) return true;
		if(b == null) return false;
		if(this.getClass() != b.getClass())return false;
		return (this.num == b.num && this.den == b.den);
	}

	
	//重写toString
	@Override
	public String toString() {
		if(this.den == 1)
			return String.format("%d", this.num);
		else
			return String.format("%d/%d", this.num,this.den);
	}
	

}















