package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem034 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem034().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long overallSum = 0;
		for (int i = 3; i < 10000000; i++) { // max is arbitrary
			int temp = i;
			int sum = 0;
			while (temp > 0 && sum <= i) {
				sum += MathUtils.fact(temp % 10).longValue();
				temp = temp / 10;
			}
			if (temp == 0 && sum == i) {
				overallSum += sum;
			}
		}
		return overallSum;
	}

}
