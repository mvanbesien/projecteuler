package fr.mvanbesien.projecteuler.from041to060;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem048 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem048().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		BigInteger result = BigInteger.valueOf(1); //1^1
		for (int i = 2;i<=1000;i++) {
			result = result.add(BigInteger.valueOf(i).pow(i));
		}
		String string = result.toString();
		return string.substring(string.length() - 10);
	}

}
