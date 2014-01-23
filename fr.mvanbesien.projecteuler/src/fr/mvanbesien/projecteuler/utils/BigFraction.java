package fr.mvanbesien.projecteuler.utils;

import java.math.BigInteger;

public final class BigFraction {
	BigInteger numerator;
	BigInteger denominator;

	public BigFraction(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return this.numerator.toString() + "/" + this.denominator.toString();
	}

	public BigFraction multiply(BigFraction f2) {
		BigInteger numerator = this.numerator.multiply(f2.numerator);
		BigInteger denominator = this.denominator.multiply(f2.denominator);
		BigInteger gcd = numerator.gcd(denominator);
		return new BigFraction(numerator.divide(gcd), denominator.divide(gcd));
	}

	public BigInteger getNumerator() {
		return numerator;
	}

	public BigInteger getDenominator() {
		return denominator;
	}

	public BigFraction add(BigFraction f2) {
		BigInteger denominator = this.denominator.multiply(f2.denominator);
		BigInteger numerator = this.numerator.multiply(denominator).divide(this.denominator)
				.add(f2.numerator.multiply(denominator).divide(f2.denominator));
		BigInteger gcd = numerator.gcd(denominator);
		return new BigFraction(numerator.divide(gcd), denominator.divide(gcd));
	}
	
	public BigFraction invert() {
		return new BigFraction(this.denominator, this.numerator);
	}
}