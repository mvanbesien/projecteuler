package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

public class Problem045 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem045().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long index = 40756;
		while (true) {
			long triangle = nextTriangle(index);
			long pentagonal = nextPentagonal(index);
			long hexagonal = nextHexagonal(index);

			if (triangle == pentagonal && triangle == hexagonal) {
				return pentagonal;
			}
			index = min(triangle, min(pentagonal, hexagonal));
		}
	}

	private long nextHexagonal(long value) {
		long x = (long) (1 + Math.sqrt(1 + 8 * value)) / 4;
		return (x + 1) * (2 * (x + 1) - 1);
	}

	private long nextTriangle(long value) {
		long x = (long) (-1 + Math.sqrt(1 + 8 * value)) / 2;
		return (x + 1) * (x + 1 + 1) / 2;
	}

	private long nextPentagonal(long value) {
		long x = (long) (1 + Math.sqrt(1 + 24 * value)) / 6;
		return (x + 1) * (3 * (x + 1) - 1) / 2;
	}
	
	private long min(long a, long b) {
		return a < b ? a : b;
	}

}
