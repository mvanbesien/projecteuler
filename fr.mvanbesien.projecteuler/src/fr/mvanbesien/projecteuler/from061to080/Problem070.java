package fr.mvanbesien.projecteuler.from061to080;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Problem070 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem070().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		double minRatio = Double.MAX_VALUE;
		long n = 0;
		for (int i = 2; i < 10000000; i++) {
			int phi = phi(i);
			if (arePermutations(i, phi)) {
				double ratio = new Double(i) / phi;
				if (ratio < minRatio) {
					minRatio = ratio;
					n = i;
				}
			}

		}
		return n;
	}

	private static boolean arePermutations(int i, int j) {
		char[] ci = String.valueOf(i).toCharArray();
		char[] cj = String.valueOf(j).toCharArray();

		Arrays.sort(ci);
		Arrays.sort(cj);

		return new String(ci).equals(new String(cj));

	}

	private static int phi(int n) {
		int result = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				result = result - result / i;
				while (n % i == 0)
					n = n / i;
			}
		}
		if (n > 1)
			result = result - result / n;
		return result;
	}

}
