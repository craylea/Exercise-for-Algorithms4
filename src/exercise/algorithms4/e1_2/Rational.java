package exercise.algorithms4.e1_2;

import exercise.algorithms4.E_Util;

public class Rational {

	private final int numerator;
	private final int denominator;
	
	public Rational(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Rational plus(Rational b){
		
		int num = this.numerator * b.denominator + this.denominator * b.numerator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) : "overflow";
		int den = this.denominator * b.denominator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) : "overflow";
		
//		int gcd = E_Util.gcd(num, den);
//		num = num / gcd;
//		den = den / gcd;
		
		return exceptGcd(num, den);
	}
	public Rational minus(Rational b){
		
		int num = this.numerator * b.denominator - this.denominator * b.numerator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE): "overflow";
		int den = this.denominator * b.denominator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) : "overflow";
		
//		int gcd = E_Util.gcd(num, den);
//		num = num / gcd;
//		den = den / gcd;
		
		return exceptGcd(num, den);
	}
	public Rational times(Rational b){
		
		int num = this.numerator * b.numerator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE): "overflow";
		int den = this.denominator * b.denominator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) : "overflow";
		
//		int gcd = E_Util.gcd(num, den);
//		num = num / gcd;
//		den = den / gcd;
		
		return exceptGcd(num, den);
	}
	public Rational devides(Rational b){
		
		int num = this.numerator * b.denominator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE): "overflow";
		int den = this.denominator * b.numerator;
		assert (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) : "overflow";
		
//		int gcd = E_Util.gcd(num, den);
//		num = num / gcd;
//		den = den / gcd;
		
		return exceptGcd(num, den);
	}
	
	private Rational exceptGcd(int numerator, int denominator){
		int gcd = E_Util.gcd(numerator, denominator);
		numerator = numerator / gcd;
		denominator = denominator / gcd;
		
		return new Rational(numerator, denominator);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Rational o = (Rational) obj;
		Rational r1 = exceptGcd(this.numerator, this.denominator);
		Rational r2 = exceptGcd(o.numerator, o.denominator);
		return (r1.numerator == r2.numerator && r1.denominator == r2.denominator);
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
	}
	
	
}
