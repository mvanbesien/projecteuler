package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem005 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem005().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long result = 19;
		while (true) {
			boolean isOK = true;
			for (int i = 2; i < 20 && isOK; i++) {
				isOK = result % i == 0;
			}
			if (isOK) {
				break;
			} else {
				result = result + 19;
			}
		}
		return result;
	}

}
