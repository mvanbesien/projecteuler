package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem049 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem049().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		List<Long> list = new ArrayList<Long>();
		for (long l = nextPrime(1488L); l < 10000L; l = nextPrime(l)) {
			list.add(l);
		}

		for (int i = 0; i < list.size(); i++) {
			Long vi = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Long vj = list.get(j);
				Long k = vj + vj - vi;
				if (list.contains(k)) {
					if (isPermutation(vi, vj) && isPermutation(vi, k)) {
						return "" + vi + vj + k;
					}
				}
			}
		}

		return null;
	}

	private long nextPrime(long i) {
		long temp = i + (i % 2 == 0 ? 1 : 2);
		while (!isPrime(temp)) {
			temp += 2;
		}
		return temp;
	}

	private boolean isPrime(long value) {
		if (value > 2 && value % 2 == 0)
			return false;
		for (int i = 3; i <= (int) Math.sqrt(value) + 1; i = i + 2) {
			if (value % i == 0)
				return false;
		}
		return true;
	}

	private boolean isPermutation(long l1, long l2) {
		char[] s1 = String.valueOf(l1).toCharArray();
		Arrays.sort(s1);
		char[] s2 = String.valueOf(l2).toCharArray();
		Arrays.sort(s2);
		if (s1.length != s2.length)
			return false;
		for (int i = 0; i < s1.length; i++) {
			if (s1[i] != s2[i])
				return false;
		}
		return true;
	}
}
