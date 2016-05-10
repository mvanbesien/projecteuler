package fr.mvanbesien.projecteuler.from081to100;

import java.util.concurrent.Callable;

public class Problem085 implements Callable<Long> {

	private static final int TARGET = 2000000;

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem085().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long[] minBelow = new long[] { 0, 0, 0 };
		long[] minOver = new long[] { 0, 0, Long.MAX_VALUE };
		for (long i = 1; i < 1000; i++) {
			for (long j = i; j < 1000 && countRectangles(i, j) < minOver[2]; j++) {
				long rectangles = countRectangles(i, j);
				if (rectangles < TARGET) {
					if (rectangles > minBelow[2]) {
						minBelow = new long[] { i, j, rectangles };
					}
				} else {
					if (rectangles < minOver[2]) {
						minOver = new long[] { i, j, rectangles };
					}
				}
			}
		}
		return TARGET - minBelow[2] < minOver[2] - TARGET ? minBelow[0] * minBelow[1] : minOver[0] * minOver[1];
	}

	private static long countRectangles(long i, long j) {
		return (i * (i + 1)) / 2 * (j * (j + 1)) / 2;
	}

}
