package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.GeometricalNumberUtils;

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
			long triangle = GeometricalNumberUtils.nextTriangle(index);
			long pentagonal = GeometricalNumberUtils.nextPentagonal(index);
			long hexagonal = GeometricalNumberUtils.nextHexagonal(index);

			if (triangle == pentagonal && triangle == hexagonal) {
				return pentagonal;
			}
			index = min(triangle, min(pentagonal, hexagonal));
		}
	}

	
	
	private long min(long a, long b) {
		return a < b ? a : b;
	}

}
