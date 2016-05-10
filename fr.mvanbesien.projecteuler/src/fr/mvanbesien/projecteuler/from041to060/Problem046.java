package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

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
			for (long prime = 2; prime <= value - 2 * power * power; prime = MathUtils.nextPrime(prime)) {
				if (value == prime + 2 * power * power) {
					return true;
				}
			}
		}
		return false;
	}

	private long nextOddNonPrime(long number) {
		long temp = number;
		if (temp % 2 == 0)
			temp++;
		else
			temp += 2;
		while (MathUtils.isPrime(temp)) {
			temp = temp + 2;
		}
		return temp;
	}

}
