package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem027 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem027().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int maxN = 0;
		int solution = 0;
		for (int a = -999; a < 999; a++) {
			for (int b = -999; b < 999; b++) {
				int n = 0;
				while (isPrime(Math.abs(n * n + a * n + b))) {
					n++;
				}
				if (n > maxN) {
					maxN = n;
					solution = a * b;
				}
			}
		}
		return (long) solution;
	}

	private static final boolean isPrime(int i) {
		if (i > 2 && i % 2 == 0)
			return false;
		for (int j = 3; j < Math.sqrt(i); j = j + 2) {
			if (i % j == 0) {
				return false;
			}
		}

		return true;
	}

}
