package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.BigFraction;

public class Problem065 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem065().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		int max = 99;
		
		BigFraction bigFraction = new BigFraction(BigInteger.ONE, BigInteger.valueOf(sequenceValue(max)));
		
		for (int i = max - 1; i > 0; i--) {
			bigFraction = bigFraction.add(new BigFraction(BigInteger.valueOf(sequenceValue(i)), BigInteger.ONE)).invert();
		}
		bigFraction = bigFraction.add(new BigFraction(BigInteger.valueOf(2), BigInteger.ONE));
		System.out.println(bigFraction);
		BigInteger numerator = bigFraction.getNumerator();
		while (!numerator.equals(BigInteger.ZERO)) {
			sum += numerator.mod(BigInteger.TEN).intValue();
			numerator = numerator.divide(BigInteger.TEN);
		}
		return sum;
	}

	public long sequenceValue(int index) {
		return (index + 1) % 3 == 0 ? 2 * (index + 1) / 3 : 1;
	}
}
