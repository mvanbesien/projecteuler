package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

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

	private List<Long> primeFactors(long value) {
		List<Long> factors = new ArrayList<>();
		long temp = value;
		long factor = 2;
		while (temp > 1) {
			while (temp % factor == 0) {
				if (!factors.contains(factor) && isPrime(factor))
					factors.add(factor);
				temp = temp / factor;
			}
			factor++;
		}
		return factors;
	}

	private boolean isPrime(long number) {
		if (number == 1)
			return false;
		if (number == 2)
			return true;
		for (long i = 3; i <= (long) Math.sqrt(number) + 1; i = i + 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
