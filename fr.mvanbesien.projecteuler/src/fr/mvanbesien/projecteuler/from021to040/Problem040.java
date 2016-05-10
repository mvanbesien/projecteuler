package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem040 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem040().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		StringBuilder builder = new StringBuilder(1000010);
		int index = 1;
		while (builder.length() < 1000000) {
			builder.append(String.valueOf(index));
			index++;
		}
		long product = 1;
		for (int i = 1;i<=1000000;i = i * 10) {
			String charAt = "" + builder.charAt(i - 1);
			product *= Integer.parseInt(charAt);
		}
		return product;
	}
}
