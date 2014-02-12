package fr.mvanbesien.projecteuler.from061to080;

import java.util.concurrent.Callable;

public class Problem075 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem075().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// http://en.wikipedia.org/wiki/Pythagorean_triple

		int[] perimeters = new int[1500001];
		for (int m = 2; m <= Math.sqrt(1500000 / 2); m++) {
			for (int n = 1; n < m; n++) {
				if ((m + n) % 2 == 1 && gcd(m, n) == 1) {
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					int l = a + b + c;
					while (l <= 1500000) {
						perimeters[l]++;
						l += a + b + c;
					}
				}
			}
		}
		int result = 0;
		for (int i = 0; i < perimeters.length; i++) {
			if (perimeters[i] == 1)
				result++;
		}
		return (long) result;
	}

	// http://www.vogella.com/tutorials/JavaAlgorithmsEuclid/article.html
	private static int gcd(int i, int j) {
		return j == 0 ? i : gcd(j, i % j);
	}

}
