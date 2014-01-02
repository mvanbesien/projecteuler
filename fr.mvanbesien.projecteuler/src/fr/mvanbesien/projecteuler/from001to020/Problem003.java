package fr.mvanbesien.projecteuler.from001to020;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;

public class Problem003 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem003().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long value = 600851475143L;
		long divisor = 2L;
		Collection<Long> primes = new ArrayList<Long>();

		while (value >= divisor) {
			while (value % divisor == 0) {
				value = value / divisor;
				primes.add(divisor);
			}
			divisor++;
		}

		return Collections.max(primes);
	}

}
