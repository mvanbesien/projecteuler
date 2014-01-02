package fr.mvanbesien.projecteuler.from001to020;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Problem014 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem014().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Map<Long, Long> cache = new HashMap<>();
		long maxValue = 0;
		long maxSteps = 0;
		for (long i = 2; i < 1000000; i++) {
			long temp = i;
			long steps = 1;
			while (temp != 1) {

				if (temp != 1 && cache.containsKey(temp)) {
					steps += cache.get(temp);
					temp = 1;
				} else {
					temp = temp % 2 == 0 ? temp / 2 : 3 * temp + 1;
					steps++;
				}

			}
			if (steps > maxSteps) {
				maxValue = i;
				maxSteps = steps;
			}
			cache.put(i, steps - 1);
		}

		return maxValue;
	}
}
