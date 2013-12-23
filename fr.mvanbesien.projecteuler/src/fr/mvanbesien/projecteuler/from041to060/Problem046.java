package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

public class Problem046 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem046().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long value = 35; // first odd composite number greater than 33
		while (isDecomposable(value)) {
			value = nextOddNonPrime(value);
		}
		return value;
	}

	private boolean isDecomposable(long value) {
		for (long power = 1; 2 * power * power <= value; power++) {
			for (long prime = 2; prime <= value - 2 * power * power; prime = nextPrime(prime)) {
				if (value == prime + 2 * power * power) {
					return true;
				}
			}
		}
		return false;
	}

	private long nextPrime(long number) {
		long temp = number;
		if (temp % 2 == 0)
			temp++;
		else
			temp += 2;

		while (!isPrime(temp)) {
			temp = temp + 2;
		}
		return temp;
	}

	private long nextOddNonPrime(long number) {
		long temp = number;
		if (temp % 2 == 0)
			temp++;
		else
			temp += 2;
		while (isPrime(temp)) {
			temp = temp + 2;
		}
		return temp;
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
