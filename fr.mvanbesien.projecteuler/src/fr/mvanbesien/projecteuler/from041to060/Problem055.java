package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.NumberUtils;

public class Problem055 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem055().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		List<BigInteger> initialConditions = new ArrayList<>();
		for (long i = 10; i <= 10000; i++) {
			initialConditions.add(BigInteger.valueOf(i));
		}
		List<BigInteger> lychrel = new ArrayList<>();

		while (initialConditions.size() > 0) {
			List<BigInteger> toRemove = new ArrayList<>();

			BigInteger value = initialConditions.get(0);
			BigInteger reverse = NumberUtils.getReverse(value);
			toRemove.add(value);
			toRemove.add(reverse);
			boolean palindromeFound = false;

			for (int i = 0; i < 50 && !palindromeFound; i++) {
				BigInteger addition = value.add(reverse);
				if (NumberUtils.isPalindrome(addition)) {
					palindromeFound = true;
				} else {
					value = addition;
					reverse = NumberUtils.getReverse(value);
					toRemove.add(value);
					toRemove.add(reverse);
				}
			}

			if (!palindromeFound) {
				lychrel.add(initialConditions.get(0));
				initialConditions.remove(initialConditions.get(0));
			} else
				initialConditions.removeAll(toRemove);

		}

		return (long) lychrel.size();
	}

}
