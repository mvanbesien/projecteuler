package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem010 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem010().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int i = 2; i < 2000000; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i) && isPrime; j++) {
				isPrime = i % j != 0;
			}
			if (isPrime) {
				sum += i;
			}
		}

		return (long) sum;
	}

}
