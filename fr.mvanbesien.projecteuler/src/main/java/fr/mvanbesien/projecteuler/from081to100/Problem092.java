package fr.mvanbesien.projecteuler.from081to100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class Problem092 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem092().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Set<Integer> trues = new HashSet<>();
		Set<Integer> falses = new HashSet<>();
		falses.add(1);
		trues.add(89);
		for (int i = 2; i < 10000000; i++) {
			List<Integer> chain = new ArrayList<>();
			int current = i;
			while (!trues.contains(current) && !falses.contains(current)) {
				chain.add(current);
				current = sumSquares(current);
			}

			if (trues.contains(current)) {
				trues.addAll(chain);
			} else {
				falses.addAll(chain);
			}
		}
		return new Long(trues.size());
	}

	private static int sumSquares(int value) {
		int temp = value;
		int total = 0;
		while (temp > 0) {
			total += (temp % 10) * (temp % 10);
			temp /= 10;
		}
		return total;
	}

}
