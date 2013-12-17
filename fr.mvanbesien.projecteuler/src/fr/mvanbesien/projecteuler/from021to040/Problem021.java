package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem021 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem021().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (long n = 0; n < 10000; n++) {
			long dn = d(n);
			long ddn = d(dn);
			if (n == ddn && n != dn) {
				sum = sum + n + dn;
			}
		}
		return sum / 2;
	}

	private static final long d(long n) {
		long sum = 1;
		for (int i = 2; i < ((int) Math.sqrt(n)) + 1; i++) {
			if (n % i == 0) {
				sum += i;
				sum += n / i;
			}
		}
		return sum;
	}

}
