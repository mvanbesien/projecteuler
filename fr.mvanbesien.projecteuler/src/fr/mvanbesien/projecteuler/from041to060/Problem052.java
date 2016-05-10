package fr.mvanbesien.projecteuler.from041to060;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Problem052 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem052().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		for (int i = 125874; true; i = next(i)) {
			if (haveSameDigits(i, 2 * i, 3 * i, 4 * i, 5 * i, 6 * i)) {
				return (long) i;
			}
		}
	}

	private boolean haveSameDigits(int... values) {
		if (values.length == 0)
				return true;
		
		String[] s = new String[values.length];
		int length = String.valueOf(values[0]).length();
		for (int i = 0; i < values.length; i++) {
			String valueOf = String.valueOf(values[i]);
			if (valueOf.length() != length)
				return false;
			
			s[i] = new String(newSortedCharArray(valueOf));
		}
		
		for (int i = 1;i<length;i++) {
			for (int j = 1;j<s.length;j++) {
				if (s[j].charAt(i) != s[0].charAt(i))
					return false;
			}
		}
		
		return true;
	}

	private int next(int number) {
		int temp = number + 1;
		while (!hasUniqueDigits(temp)) {
			temp++;
		}
		return temp;
	}

	private boolean hasUniqueDigits(int number) {
		char[] values = String.valueOf(number).toCharArray();
		Arrays.sort(values);
		for (int i = 0; i < values.length - 1; i++) {
			if (values[i] == values[i + 1])
				return false;
		}
		return true;
	}
	
	private char[] newSortedCharArray(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return charArray;
	}

}
