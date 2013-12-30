package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class Problem057 implements Callable<Long> {

	public static final class Fraction {
		BigInteger numerator;
		BigInteger denominator;

		Fraction(BigInteger numerator, BigInteger denominator) {
			BigInteger gcd = numerator.gcd(denominator);
			this.numerator = numerator.divide(gcd);
			this.denominator = denominator.divide(gcd);
		}

		@Override
		public String toString() {
			return "" + numerator + "/" + denominator;
		}
	}

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem057().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		MyIterator myIterator = new MyIterator();
		long sum = 0;
		for (int i = 0; i < 1000; i++) {
			Fraction f = myIterator.next();
			if (String.valueOf(f.numerator).length() > String.valueOf(f.denominator).length()) {
				sum++;
			}
		}
		return sum;
	}

	private static final class MyIterator implements Iterator<Fraction> {

		Fraction lastFraction = null;

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Fraction next() {
			if (lastFraction == null) {
				Fraction f = new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(2));
				lastFraction = f;
			} else {
				BigInteger newNum = lastFraction.denominator;
				BigInteger newDenom = lastFraction.denominator.multiply(BigInteger.valueOf(2)).add(
						lastFraction.numerator.subtract(lastFraction.denominator));
				lastFraction = new Fraction(newNum.add(newDenom), newDenom);
			}

			return lastFraction;
		}

		@Override
		public void remove() {
		}
	}
}
