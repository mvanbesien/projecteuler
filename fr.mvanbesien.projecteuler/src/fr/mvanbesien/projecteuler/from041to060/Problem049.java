package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem049 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem049().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		List<Long> list = new ArrayList<Long>();
		for (long l = MathUtils.nextPrime(1488L); l < 10000L; l = MathUtils.nextPrime(l)) {
			list.add(l);
		}

		for (int i = 0; i < list.size(); i++) {
			Long vi = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				Long vj = list.get(j);
				Long k = vj + vj - vi;
				if (list.contains(k) && isPermutation(vi, vj) && isPermutation(vi, k)) {
					return "" + vi + vj + k;
				}
			}
		}

		return null;
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
