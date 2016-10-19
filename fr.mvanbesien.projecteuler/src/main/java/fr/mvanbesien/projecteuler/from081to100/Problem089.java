package fr.mvanbesien.projecteuler.from081to100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Problem089 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem089().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Long gained = 0L;
		BufferedReader reader = new BufferedReader(new InputStreamReader(Problem089.class.getResourceAsStream("/Problem089.txt")));
		while (reader.ready()) {
			String line = reader.readLine().trim();
			String compress = toRomanValue(toNumericValue(line));
			gained += (line.length() - compress.length());
		}
		return gained;
	}

	private static int toNumericValue(String romanValue) {
		int value = 0;
		for (int i = 0; i < romanValue.length(); i++) {
			char c = romanValue.charAt(i);
			if (c == 'I') {
				if (i + 1 < romanValue.length() && (romanValue.charAt(i + 1) == 'V' || romanValue.charAt(i + 1) == 'X')) {
					value -= 1;
				} else {
					value += 1;
				}
			} else if (c == 'V') {
				value += 5;
			} else if (c == 'X') {
				if (i + 1 < romanValue.length() && (romanValue.charAt(i + 1) == 'L' || romanValue.charAt(i + 1) == 'C')) {
					value -= 10;
				} else {
					value += 10;
				}
			} else if (c == 'L') {
				value += 50;
			} else if (c == 'C') {
				if (i + 1 < romanValue.length() && (romanValue.charAt(i + 1) == 'D' || romanValue.charAt(i + 1) == 'M')) {
					value -= 100;
				} else {
					value += 100;
				}
			} else if (c == 'D') {
				value += 500;
			} else if (c == 'M') {
				value += 1000;
			}
		}

		return value;
	}

	private static final String toRomanValue(int value) {
		String result = "";
		final String[] units = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		final String[] tenths = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		final String[] hundreds = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		final String[] thousands = new String[] { "", "M", "MM", "MMM", "MMMM", "MMMMM", "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM" };

		result = units[value % 10] + result;
		value = value / 10;
		result = tenths[value % 10] + result;
		value = value / 10;
		result = hundreds[value % 10] + result;
		value = value / 10;
		result = thousands[value % 10] + result;

		return result;
	}

}
