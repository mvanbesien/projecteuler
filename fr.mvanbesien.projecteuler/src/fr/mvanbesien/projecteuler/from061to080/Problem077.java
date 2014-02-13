package fr.mvanbesien.projecteuler.from061to080;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem077 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem077().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		for (long result = 10; true; result++) {
			AtomicLong value = new AtomicLong();
			getDecompositions(result, 2, value);
			if (value.get() > 5000)
				return result;
		}
	}

	private void getDecompositions(long number, long limit, AtomicLong result) {
		for (long i = limit; i <= number; i = MathUtils.nextPrime(i)) {
			if (number - i == 0) {
				result.incrementAndGet();
			} else {
				getDecompositions(number - i, i, result);
			}
		}
	}
}
