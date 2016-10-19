package fr.mvanbesien.projecteuler.from001to020;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem016 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem016().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		BigInteger d = BigInteger.valueOf(2);
		d = d.pow(1000);
		String string = d.toString();
		int sum = 0;
		for (int i = 0;i<string.length();i++) {
			sum += Integer.parseInt(""+string.charAt(i));
		}
		return (long) sum;
	}

}
