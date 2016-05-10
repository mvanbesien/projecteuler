package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem006 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem006().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		long squaredSum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
			squaredSum += (i * i);
		}
		return (-squaredSum + sum * sum);
	}

}
