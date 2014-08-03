package fr.mvanbesien.projecteuler.from061to080;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Problem078 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem078().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private Map<Integer, Integer> cache = new HashMap<>();

	private int value(int n) {
		if (!cache.containsKey(n)) {
			if (n < 0)
				return 0;
			if (n == 0)
				return 1;
			else {
				int result = 0;
				for (int i = 1, temp = pentagon(1); temp <= n; i++) {
					temp = pentagon(i);
					result = (result + (i % 2 == 0 ? -1 : 1) * value(n - temp) + 1000000) % 1000000;
				}
				for (int i = -1, temp = pentagon(-1); temp <= n; i--) {
					temp = pentagon(i);
					result = (result + (i % 2 == 0 ? -1 : 1) * value(n - temp) + 1000000) % 1000000;
				}
				cache.put(n, result);
			}
		}
		return cache.get(n);
	}

	private static int pentagon(int n) {
		return n * (n * 3 - 1) / 2;
	}

	@Override
	public Long call() throws Exception {

		for (int i = 0;; i++) {
			if (value(i) == 0)
				return (long) i;
		}
	}
}
