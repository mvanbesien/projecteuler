package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem007 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem007().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int currentNumber = 1;
		int primeIndex = 1;

		while (primeIndex < 10001) {
			currentNumber = currentNumber + 2;
			boolean isPrime = currentNumber % 2 != 0;
			for (int i = 3; i <= currentNumber / 2 + 1 && isPrime; i = i + 1) {
				isPrime = currentNumber % i != 0;
			}
			if (isPrime) {
				primeIndex++;
			}
			
		}
		return (long) currentNumber;
	}

}
