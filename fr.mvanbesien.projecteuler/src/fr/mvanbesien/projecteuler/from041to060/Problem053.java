package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem053 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem053().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long addition = 0;
		for (int n = 1; n <= 100; n++) {
			boolean breakLoop = false;
			for (int r = 1; r <= n && !breakLoop; r++) {
				BigInteger bi = comb(n, r);
				if (bi.toString().length() >= "1000000".length()) {
					addition = addition + (n - 2 * r + 1);
					breakLoop = true;

				}
			}
		}

		return addition;
	}

	private BigInteger fact(long value) {

		BigInteger fact = BigInteger.valueOf(1);
		for (int i = 2; i <= value; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	private BigInteger comb(long n, long r) {
		return fact(n).divide(fact(r)).divide(fact(n - r));
	}

}
