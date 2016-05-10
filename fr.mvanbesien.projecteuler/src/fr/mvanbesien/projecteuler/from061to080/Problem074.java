package fr.mvanbesien.projecteuler.from061to080;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem074 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem074().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long number = 0;
		//Map<Long, Integer> mappings = new HashMap<>();
		for (int i = 69; i < 1000000; i++) {
			List<Long> chain = new ArrayList<>();
			chain.add((long) i);
			long value = factSum(i);
			boolean loop = true;
			while (loop && chain.size() <= 60) {
//				if (mappings.containsKey(value)) {
//					loop = false;
//				} else {
					if (chain.contains(value)) {
						loop = false;
					} else {
						chain.add(value);
						value = factSum(value);
					}
//				}
			}

//			int chainLength = chain.size() + (mappings.containsKey(value) ? mappings.get(value) : 0);
//			for (Long l : chain) {
//				mappings.put(l, chainLength);
//			}
			if (chain.size()== 60)
				number++;
		}
		return number;
	}

	public static long fact(long l) {
		if (l < 1)
			return 1;
		long fact = 1;
		for (int i = 2; i <= l; i++) {
			fact = fact * i;
		}
		return fact;
	}

	public static long factSum(long l) {
		long temp = l;
		long sum = 0;
		while (temp > 0) {
			sum += fact(temp % 10);
			temp = temp / 10;
		}
		return sum;
	}

}
