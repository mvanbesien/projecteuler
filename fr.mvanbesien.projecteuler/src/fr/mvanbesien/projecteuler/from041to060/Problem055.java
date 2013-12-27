package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

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
			BigInteger reverse = getReverse(value);
			toRemove.add(value);
			toRemove.add(reverse);
			boolean palindromeFound = false;

			for (int i = 0; i < 50 && !palindromeFound; i++) {
				BigInteger addition = value.add(reverse);
				if (isPalindrome(addition.toString())) {
					palindromeFound = true;
				} else {
					value = addition;
					reverse = getReverse(value);
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

	private static boolean isPalindrome(String string) {
		int length = string.length();
		boolean isPalindrome = true;
		for (int i = 0; i < length / 2 + 1 && isPalindrome; i++) {
			isPalindrome = string.charAt(i) == string.charAt(length - i - 1);
		}
		return isPalindrome;
	}

	private static BigInteger getReverse(BigInteger integer) {
		String value = integer.toString();
		String reverse = "";
		for (int i = 0; i < value.length(); i++) {
			reverse = "" + value.charAt(i) + reverse;
		}
		return new BigInteger(reverse);
	}

}
