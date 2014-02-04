package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem073 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem073().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long number = 0;
		double minRatio = 1d / 3;
		double maxRatio = 1d / 2;
		for (int i = 1; i <= 12000; i++) {
			int num2 = (int) (minRatio * i + 1);
			double ratio2 = new Double(num2) / i;
			while (ratio2 < maxRatio) {
				if (gcd(num2, i) == 1)
					number++;
				num2++;
				ratio2 = new Double(num2) / i;
			}
		}
		return number;
	}

	private static int gcd(int i, int j) {
		return BigInteger.valueOf(i).gcd(BigInteger.valueOf(j)).intValue();
	}

}
