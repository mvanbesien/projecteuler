package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.Fraction;

public class Problem071 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem071().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// List<Fraction> fractions = new ArrayList<>();
		double ratio = 3d / 7;
		double diff = Double.MAX_VALUE;
		int numerator = 0;
		int denominator = 0;
		for (int i = 1; i <= 1000000; i++) {
			int num2 = (int) (ratio * i);
			double ratio2 = new Double(num2) / i;
			if (ratio - ratio2 > 0 && ratio - ratio2 <= diff) {
				numerator = num2;
				denominator = i;
				diff = ratio - ratio2;

			}
		}

		System.out.println(new Fraction(numerator, denominator));
		return (long) numerator / gcd(numerator, denominator);
	}

	private static int gcd(int i, int j) {
		return BigInteger.valueOf(i).gcd(BigInteger.valueOf(j)).intValue();
	}

}
