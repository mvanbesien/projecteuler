package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem004 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem004().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long max = 0;

		for (int i = 100; i < 1000; i++) {
			for (int j = i; j < 1000; j++) {
				String s = Integer.toString(i * j);
				boolean isPalindrome = true;
				for (int k = 0; k <= s.length() / 2 + 1 && isPalindrome; k++) {
					isPalindrome = s.charAt(k) == s.charAt(s.length() - k - 1);
				}
				if (isPalindrome & i * j > max) {
					max = i * j;
				}
			}
		}
		return max;
	}

}
