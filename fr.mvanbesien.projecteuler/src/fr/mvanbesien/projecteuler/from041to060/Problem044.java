package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.GeometricalNumberUtils;

public class Problem044 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem044().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long minDiff = Long.MAX_VALUE;
		for (long s = 1; s < 100000000; s = GeometricalNumberUtils.nextPentagonal(s)) {
			for (long j = 1; j < s / 2; j = GeometricalNumberUtils.nextPentagonal(j)) {
				long k = s - j;
				long d = Math.abs(j - k);
				if (GeometricalNumberUtils.isPentagonal(k) && GeometricalNumberUtils.isPentagonal(d)) {
					if (d < minDiff)
						minDiff = d;
				}
			}
		}
		return minDiff;
	}

}
