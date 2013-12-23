package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem050 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem050().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		List<Long> primesAdditionList = new ArrayList<Long>();
		primesAdditionList.add(0L);
		long addition = 0;
		for (long prime = 2; prime <= 1000000 && addition < 1000000; prime = nextPrime(prime)) {
			addition += prime;
			if (addition < 1000000)
				primesAdditionList.add(addition);
		}

		Long[] primesAdditions = primesAdditionList.toArray(new Long[primesAdditionList.size()]);
		long maxNumber = 0;
		long termsSum = 0;
		for (int i = primesAdditions.length - 1; i >= 0; i--) {
			for (int j = 0; j < i && i - j > termsSum; j++) {
				if (isPrime(primesAdditions[i] - primesAdditions[j])) {
					maxNumber = primesAdditions[i] - primesAdditions[j];
					termsSum = i - j;
				}
			}
		}
		return maxNumber;
	}

	private long nextPrime(long i) {
		long temp = i + (i % 2 == 0 ? 1 : 2);
		while (!isPrime(temp)) {
			temp += 2;
		}
		return temp;
	}

	private boolean isPrime(long value) {
		if (value > 2 && value % 2 == 0)
			return false;
		for (long i = 3; i <= (int) Math.sqrt(value) + 1; i = i + 2) {
			if (value % i == 0)
				return false;
		}
		return true;
	}

}
