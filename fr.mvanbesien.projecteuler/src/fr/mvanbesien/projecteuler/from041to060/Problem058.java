package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

public class Problem058 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem058().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// We start as with the example
		long spiralSide = 7;
		long numberOfElements = 13;
		long numberOfPrimes = 8;

		while (new Double(100 * numberOfPrimes) / numberOfElements > 10) {
			numberOfElements += 4; // Four more diagonal elements;
			spiralSide += 2;
			long newDiagValues[] = new long[] { spiralSide * spiralSide, spiralSide * spiralSide - (spiralSide - 1),
					spiralSide * spiralSide - 2 * (spiralSide - 1), spiralSide * spiralSide - 3 * (spiralSide - 1) };
			for (long l : newDiagValues) {
				if (isPrime(l))
					numberOfPrimes++;
			}
		}
		return spiralSide;
	}
	
	private boolean isPrime(long value) {

		if (value > 2 && value % 2 == 0)
			return false;

		for (int i = 3; i <= (int) Math.sqrt(value) + 1; i = i + 2) {
			if (value % i == 0)
				return false;
		}
		return true;
	}

}
