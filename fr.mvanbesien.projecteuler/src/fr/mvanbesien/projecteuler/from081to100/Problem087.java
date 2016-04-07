package fr.mvanbesien.projecteuler.from081to100;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem087 implements Callable<Long> {

	private static final int LIMIT = 50000000;

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem087().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Set<Long> set = new HashSet<Long>();
		long base = 2;
		while (pow(base, 2) + pow(2, 3) + pow(2, 4) <= LIMIT) {
			for (long a = 2; a <= base; a = MathUtils.nextPrime(a)) {
				for (long b = a; b <= base; b = MathUtils.nextPrime(b)) {
					addIfLess(set, pow(a, 2) + pow(b, 3) + pow(base, 4));
					addIfLess(set, pow(a, 2) + pow(b, 4) + pow(base, 3));
					addIfLess(set, pow(a, 3) + pow(b, 2) + pow(base, 4));
					addIfLess(set, pow(a, 3) + pow(b, 4) + pow(base, 2));
					addIfLess(set, pow(a, 4) + pow(b, 3) + pow(base, 2));
					addIfLess(set, pow(a, 4) + pow(b, 2) + pow(base, 3));
				}
			}
			base = MathUtils.nextPrime(base);
		}
		return (long) set.size();
	}

	public void addIfLess(Set<Long> s, long l) {
		if (l < LIMIT) {
			s.add(l);
		}
	}

	public long pow(long a, long b) {
		long result = 1;
		for (int i = 0; i < b; i++) {
			result = result * a;
		}
		return result;
	}

}
