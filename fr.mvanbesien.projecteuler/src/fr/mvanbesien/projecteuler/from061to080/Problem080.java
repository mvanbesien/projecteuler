package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

public class Problem080 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem080().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int maxValue = 100;
		Set<Integer> toAvoid = new HashSet<>();
		for (int i = 1; i * i <= maxValue; i++) {
			toAvoid.add(i * i);
		}

		Long value = 0L;

		for (int i = 2; i < 100; i++) {
			if (!toAvoid.contains(i)) {
				BigDecimal d = sqrt(BigDecimal.valueOf(i), 101);
				String s = d.toString().replace(".", "").substring(0, 100);
				long subTotal = 0;
				for (char c : s.toCharArray()) {
					subTotal += (int) ((char) c - '0');
				}
				value += subTotal;
			}
		}
		return value;
	}

	public static BigDecimal sqrt(BigDecimal a, final int scale) {
		BigDecimal x0 = new BigDecimal("0");
		BigDecimal x1 = new BigDecimal(Math.sqrt(a.doubleValue()));
		BigDecimal two = BigDecimal.valueOf(2L);
		while (!x0.equals(x1)) {
			x0 = x1;
			x1 = a.divide(x0, scale, BigDecimal.ROUND_HALF_UP);
			x1 = x1.add(x0);
			x1 = x1.divide(two, scale, BigDecimal.ROUND_HALF_UP);
		}
		return x1;
	}
}
