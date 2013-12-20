package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

public class Problem044 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem044().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long minDiff = Long.MAX_VALUE;
		for (long s = 1; s < 100000000; s = nextPentagonal(s)) {
			for (long j = 1; j < s / 2; j = nextPentagonal(j)) {
				long k = s - j;
				long d = Math.abs(j - k);
				if (isPentagonal(k) && isPentagonal(d)) {
					if (d < minDiff)
						minDiff = d;
				}
			}
		}
		return minDiff;
	}

	private long getPentagonal(long value) {
		return value * (3 * value - 1) / 2;
	}

	private boolean isPentagonal(long value) {
		if (value <= 1)
			return false;
		long x = (long) (1 + Math.sqrt(1 + 24 * value)) / 6;
		return getPentagonal(x) == value;
	}

	private long nextPentagonal(long value) {
		long x = (long) (1 + Math.sqrt(1 + 24 * value)) / 6;
		return getPentagonal(x + 1);
	}

}
