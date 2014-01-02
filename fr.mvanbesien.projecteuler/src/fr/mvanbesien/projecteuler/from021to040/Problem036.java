package fr.mvanbesien.projecteuler.from021to040;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.NumberUtils;

public class Problem036 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem036().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int i = 1; i < 1000; i++) {
			int i1 = NumberUtils.getMirror(i, true);
			if (NumberUtils.isPalindrome(BigInteger.valueOf(i1))) {
				sum += i1;
			}

			int i2 = NumberUtils.getMirror(i, false);
			if (NumberUtils.isPalindrome(BigInteger.valueOf(i2))) {
				sum += i2;
			}

		}
		return sum;
	}

	
}
