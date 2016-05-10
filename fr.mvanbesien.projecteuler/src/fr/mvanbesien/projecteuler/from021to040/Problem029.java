package fr.mvanbesien.projecteuler.from021to040;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem029 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem029().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		List<String> list = new ArrayList<String>();
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; j <= 100; j++) {
				BigInteger bi = BigInteger.valueOf(j);
				String value = bi.pow(i).toString();
				if (!list.contains(value))
					list.add(value);
			}
		}
		return (long) list.size();
	}

}
