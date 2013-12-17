package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem001 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem001().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long total = 0;
		for (int i = 0;i<1000;i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				total += i;
			}
		}
		return total;
	}

}
