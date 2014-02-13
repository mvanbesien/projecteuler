package fr.mvanbesien.projecteuler.from061to080;

import java.util.concurrent.Callable;

public class Problem076 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem076().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private long count;

	@Override
	public Long call() throws Exception {
		this.count = 0;
		getDecompositions(100, 1);
		return count - 1;
	}

	private void getDecompositions(int number, int limit) {
		for (int i = limit; i <= number; i++) {
			if (number - i == 0) {
				count++;
			} else {
				getDecompositions(number - i, i);
			}
		}
	}
}
