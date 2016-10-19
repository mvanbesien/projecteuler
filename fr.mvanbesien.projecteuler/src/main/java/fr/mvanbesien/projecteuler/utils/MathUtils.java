package fr.mvanbesien.projecteuler.utils;

import java.math.BigInteger;

public class MathUtils {

	public static long nextPrime(long i) {
		long temp = i + (i % 2 == 0 ? 1 : 2);
		while (!isPrime(temp)) {
			temp += 2;
		}
		return temp;
	}

	public static boolean isPrime(long value) {
		if (value > 2 && value % 2 == 0)
			return false;
		for (int i = 3; i <= (int) Math.sqrt(value) + 1; i = i + 2) {
			if (value % i == 0)
				return false;
		}
		return true;
	}

	public static BigInteger fact(long value) {

		BigInteger fact = BigInteger.valueOf(1);
		for (int i = 2; i <= value; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	public static BigInteger comb(long n, long r) {
		return fact(n).divide(fact(r)).divide(fact(n - r));
	}

}
