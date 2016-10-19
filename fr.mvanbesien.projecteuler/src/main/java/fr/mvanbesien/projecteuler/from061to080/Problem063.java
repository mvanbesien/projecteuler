package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem063 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem063().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int i = 1; i < 1000; i++) {
			boolean stop = false;
			for (int j = 1; !stop; j++) {
				BigInteger bi = BigInteger.valueOf(j).pow(i);
				if (bi.toString().length() == i)
					sum++;
				stop = bi.toString().length() > i;
			}
		}
		return sum;
	}

}
