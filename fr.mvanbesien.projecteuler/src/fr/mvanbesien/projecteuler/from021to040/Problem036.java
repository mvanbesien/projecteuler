package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

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
			int i1 = getMirror(i, true);
			if (isPalindrome(Integer.toBinaryString(i1))) {
				sum += i1;
			}

			int i2 = getMirror(i, false);
			if (isPalindrome(Integer.toBinaryString(i2))) {
				sum += i2;
			}

		}
		return sum;
	}

	private static int getMirror(int number, boolean considerLast) {
		int result = number;
		int reminder = number;
		if (!considerLast)
			reminder = reminder / 10;
		while (reminder > 0) {
			result = result * 10 + reminder % 10;
			reminder = reminder / 10;
		}

		return result;
	}

	private static boolean isPalindrome(String string) {
		int length = string.length();
		boolean isPalindrome = true;
		for (int i = 0; i < length / 2 + 1 && isPalindrome; i++) {
			isPalindrome = string.charAt(i) == string.charAt(length - i - 1);
		}
		return isPalindrome;
	}

}
