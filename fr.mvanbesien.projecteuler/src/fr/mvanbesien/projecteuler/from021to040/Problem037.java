package fr.mvanbesien.projecteuler.from021to040;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem037 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem037().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		List<Long> truncatablePrimes = new ArrayList<Long>();
		long prime = 11L;
		while (truncatablePrimes.size() < 11 && prime < (Long.MAX_VALUE - Integer.MAX_VALUE)) {

			boolean isTruncatablePrime = true;
			long tempLeft = prime / 10;
			long tempRight = Integer.parseInt(String.valueOf(prime).substring(1));
			while (tempLeft > 0 && tempRight > 0 && isTruncatablePrime) {
				if (!MathUtils.isPrime(tempLeft))
					isTruncatablePrime = false;
				else if (!MathUtils.isPrime(tempRight))
					isTruncatablePrime = false;
				else {
					tempLeft = tempLeft / 10;
					tempRight = tempRight < 10 ? 0 : Integer.parseInt(String.valueOf(tempRight).substring(1));
				}
			}
			if (isTruncatablePrime) {
				truncatablePrimes.add(prime);
				sum += prime;
			}
			prime = prime + 2;
			while (!MathUtils.isPrime(prime)) {
				prime = prime + 2;
			}
		}
		return sum;
	}
}
