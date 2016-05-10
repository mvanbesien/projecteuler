package fr.mvanbesien.projecteuler.from021to040;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class Problem023 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem023().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private static final long d(long n) {
		long sum = 0;
		for (int i = 1; i < ((int) Math.sqrt(n)) + 1; i++) {
			if (n % i == 0) {
				sum += i;
				if (n / i != i && n / i != n)
					sum += n / i;
			}
		}
		return sum;
	}

	@Override
	public Long call() throws Exception {
		Set<Integer> candidates = new LinkedHashSet<Integer>();
		for (int i = 1; i <= 28123; i++) {
			candidates.add(i);
		}
		Set<Integer> allValues = new LinkedHashSet<Integer>();
		for (int i = 1; i <= 28123; i++) {
			if (i < d(i)) {
				allValues.add(i);
			}
		}

		Integer[] allValues2 = allValues.toArray(new Integer[allValues.size()]);

		for (int i = 0; i < allValues2.length && allValues2[i] + allValues2[i] >= i; i++) {
			for (int j = i; j < allValues2.length && allValues2[i] + allValues2[j] >= i; j++) {
				int sum = allValues2[i] + allValues2[j];
				candidates.remove(sum);
			}
		}

		int sum = 0;
		for (int candidate : candidates)
			sum += candidate;

		return (long) sum;
	}

}
