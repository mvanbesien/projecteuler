package fr.mvanbesien.projecteuler.utils;

import java.math.BigInteger;

public final class Fraction implements Comparable<Fraction> {
	int numerator;
	int denominator;

	public Fraction(int numerator, int denominator) {
		int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;
	}

	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Fraction))
			return false;
		return compareTo((Fraction) obj) == 0;
	}

	public static Fraction multiply(Fraction f1, Fraction f2) {
		int numerator = f1.numerator * f2.numerator;
		int denominator = f1.denominator * f2.denominator;
		int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
		return new Fraction(numerator / gcd, denominator / gcd);
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	@Override
	public int compareTo(Fraction o) {
		double diff = new Double(this.numerator) / this.denominator - new Double(o.numerator) / o.denominator;
		return (int) Math.signum(diff);
	}

}