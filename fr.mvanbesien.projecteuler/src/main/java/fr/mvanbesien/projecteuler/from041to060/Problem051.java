package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem051 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem051().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long prime = MathUtils.nextPrime(56003);
		while (true) {
			String primeAsString = String.valueOf(prime);
			for (char c1 : primeAsString.toCharArray()) {
				List<Long> primes = new ArrayList<>();
				for (char c2 : "0123456789".toCharArray()) {
					String replace = primeAsString.replace(c1, c2);
					if (!replace.startsWith("0")) {
						long temp = Long.parseLong(replace);
						if (MathUtils.isPrime(temp)) {
							primes.add(temp);
						}
					}
				}
				if (primes.size() >= 8) {
					{
						for (long p : primes)
							System.out.print(p + " ");
						System.out.println("");

					}
					return Collections.min(primes);
				}
				prime = MathUtils.nextPrime(prime);
			}
		}
	}

}
