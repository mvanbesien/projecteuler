package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem028 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem028().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int sum = 1;
		for (int i = 1; i <= 500; i++) {
			int r = 2 * i + 1;
			int r2 = r * r;
			sum += r2 + (r2 - r + 1) + (r2 -2*r + 2) + (r2 - 3*r + 3); 
		}
		return (long) sum;
	}

}
