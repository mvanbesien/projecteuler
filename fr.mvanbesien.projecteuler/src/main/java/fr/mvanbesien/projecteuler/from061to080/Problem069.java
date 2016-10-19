package fr.mvanbesien.projecteuler.from061to080;

import java.util.concurrent.Callable;

public class Problem069 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem069().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		double maxRatio = 0;
		long n = 0;
		for (int i = 2; i <= 1000000; i++) {
			double ratio = new Double(i) / phi(i);
			if (ratio > maxRatio) {
				maxRatio = ratio;
				n = i;
			}
		}
		return n;
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
