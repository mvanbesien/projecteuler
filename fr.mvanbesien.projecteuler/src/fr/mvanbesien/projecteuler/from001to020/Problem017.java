package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem017 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem017().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		String[] digits = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		String[] digits2 = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "nineteen" };

		String[] tenths = new String[] { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
				"ninety" };

		String hundred = "hundred";
		String and = "and";

		int sizeFrom1To9 = 0;
		int sizeFrom10To19 = 0;

		for (int i = 0; i < 10; i++) {
			sizeFrom1To9 += digits[i].length();
			sizeFrom10To19 += digits2[i].length();
		}

		int sizeFrom1To99 = sizeFrom1To9 + sizeFrom10To19;
		for (int i = 2; i < tenths.length; i++) {
			sizeFrom1To99 += 10 * tenths[i].length() + sizeFrom1To9;
		}

		int sizeFrom1To999 = sizeFrom1To99;
		for (int i = 1; i < 10; i++) {
			sizeFrom1To999 += (digits[i].length() + hundred.length()) * 100 + 99 * and.length() + sizeFrom1To99;
		}

		int sizeFrom1To1000 = sizeFrom1To999 + "onethousand".length();

		return (long) sizeFrom1To1000;
	}

}
