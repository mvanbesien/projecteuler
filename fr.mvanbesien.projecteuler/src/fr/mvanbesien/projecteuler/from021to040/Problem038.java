package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem038 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem038().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long realMax = 0;

		// N has to be greater than one... Ideal initial is 9876... Lowest
		// expected would be 9123...
		for (long l = 9876; l >= 9123; l--) {
			String value = String.valueOf(l) + String.valueOf(l * 2);
			if (isPandigital(value)) {
				Long v = Long.parseLong(value);
				if (v > realMax)
					realMax = v;
			}
		}

		return realMax;
	}

	private boolean isPandigital(String result) {
		if (result.length() != 9)
			return false;
		for (int i = 1; i <= 9; i++) {
			if (result.indexOf("" + i) == -1)
				return false;
		}
		return true;
	}

}
