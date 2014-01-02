package fr.mvanbesien.projecteuler.utils;

import java.math.BigInteger;

public class NumberUtils {

	public static boolean isPalindrome(BigInteger bigInteger) {
		String string = bigInteger.toString();
		int length = string.length();
		boolean isPalindrome = true;
		for (int i = 0; i < length / 2 + 1 && isPalindrome; i++) {
			isPalindrome = string.charAt(i) == string.charAt(length - i - 1);
		}
		return isPalindrome;
	}

	public static BigInteger getReverse(BigInteger integer) {
		String value = integer.toString();
		String reverse = "";
		for (int i = 0; i < value.length(); i++) {
			reverse = "" + value.charAt(i) + reverse;
		}
		return new BigInteger(reverse);
	}
	
}
