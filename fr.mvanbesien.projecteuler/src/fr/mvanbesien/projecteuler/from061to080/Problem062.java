package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class Problem062 implements Callable<BigInteger> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem062().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}
	
	@Override
	public BigInteger call() throws Exception {
		Map<String, List<BigInteger>> values = new HashMap<>();
		BigInteger value = BigInteger.valueOf(345);
		while (true) {
			BigInteger power = value.pow(3);
			char[] bytes = power.toString().toCharArray();
			Arrays.sort(bytes);
			String key = new String(bytes);
			
			List<BigInteger> bigIntegers = values.get(key);
			if (bigIntegers == null) {
				bigIntegers = new ArrayList<>();
				values.put(key, bigIntegers);
			}
			if (bigIntegers.size() == 4) {
				return bigIntegers.get(0);
			} else {
				bigIntegers.add(power);
			}
			value = value.add(BigInteger.ONE);
		}
	}

}
