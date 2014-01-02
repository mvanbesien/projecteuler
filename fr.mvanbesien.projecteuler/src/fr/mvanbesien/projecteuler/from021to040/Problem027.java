package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

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
				while (MathUtils.isPrime(Math.abs(n * n + a * n + b))) {
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
}
