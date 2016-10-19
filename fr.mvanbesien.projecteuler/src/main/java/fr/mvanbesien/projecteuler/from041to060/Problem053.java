package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem053 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem053().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long addition = 0;
		for (int n = 1; n <= 100; n++) {
			boolean breakLoop = false;
			for (int r = 1; r <= n && !breakLoop; r++) {
				BigInteger bi = MathUtils.comb(n, r);
				if (bi.toString().length() >= "1000000".length()) {
					addition = addition + (n - 2 * r + 1);
					breakLoop = true;

				}
			}
		}

		return addition;
	}

	

}
