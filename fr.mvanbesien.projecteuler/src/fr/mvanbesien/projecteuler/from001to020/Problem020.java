package fr.mvanbesien.projecteuler.from001to020;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem020 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem020().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long i = 1;
		BigInteger b = BigInteger.valueOf(i);

		while (i < 100) {
			i++;
			b = b.multiply(BigInteger.valueOf(i));
		}
		
		String s = b.toString();
		int sum = 0;
		for (int j = 0;j<s.length();j++) {
			sum += Integer.parseInt(""+s.charAt(j));
		}
		
		return (long) sum;
	}

}
