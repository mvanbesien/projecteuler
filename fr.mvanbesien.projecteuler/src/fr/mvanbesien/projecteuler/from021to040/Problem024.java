package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem024 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem024().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		final long indexToReach = 1000000;
		long base = 1;
		String digits = "0123456789";
		String combination = "";
		while (digits.length() > 0) {
			int index = (int) ((indexToReach - base) / MathUtils.fact(digits.length() - 1).longValue());
			base = base += index * MathUtils.fact(digits.length() - 1).longValue();
			combination = combination + digits.charAt(index);
			digits = digits.substring(0, index) + digits.substring(index + 1);
		}
		return combination;
	}

}
