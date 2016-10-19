package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem009 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem009().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// 33*33 is already greater than 1000 :)
		for (int a = 1; a < 1000; a++) {
			for (int b = a + 1; b < 1000; b++) {
				int c = 1000 - a - b;
				if (a * a + b * b == c * c) {
					return (long) a * b * c;
				}
			}
		}
		return null;
	}

}
