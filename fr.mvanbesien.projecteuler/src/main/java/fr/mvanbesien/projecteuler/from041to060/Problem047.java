package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem047 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem047().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long value = 644;
		boolean[] hasFour = new boolean[] { false, false, false, false };
		while (!hasFour[0] || !hasFour[1] || !hasFour[2] || !hasFour[3]) {
			hasFour[(int) value % 4] = primeFactors(value).size() == 4;
			value++;
		}
		return value - 4;
	}

	private List<Long> primeFactors(long value, int limit) {
		List<Long> factors = new ArrayList<>();
		long temp = value;
		long factor = 2;
		while (temp > 1 && factors.size() <= limit) {
			while (temp % factor == 0 && factors.size() <= limit) {
				if (!factors.contains(factor) && MathUtils.isPrime(factor))
					factors.add(factor);
				temp = temp / factor;
			}
			factor++;
		}
		return factors;
	}

	private List<Long> primeFactors(long value) {
		return primeFactors(value, Integer.MAX_VALUE);
	}

}
