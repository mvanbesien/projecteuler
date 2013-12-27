package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem056 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem056().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long maxSum = 0;
		for (int a = 0;a<100;a++) {
			for (int b = 0;b<100;b++) {
				int sum = 0;
				BigInteger wow = BigInteger.valueOf(a).pow(b);
				for (char c : wow.toString().toCharArray()) {
					sum += c - '0';
				}
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}

}
