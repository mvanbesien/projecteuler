package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem041 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem041().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		for (int j = 9; j > 1; j--) {
			long i = 0;
			while (i < MathUtils.fact(j).longValue()) {
				long max = nextLowerPandigital(i, j);
				if (MathUtils.isPrime(max))
					return max;
				i++;
			}
		}
		return null;
	}

	private long nextLowerPandigital(long value, int length) {
		long temp = value;
		String initial = "";
		for (int i = 1; i <= length; i++) {
			initial = "" + i + initial;
		}
		String result = "";
		while (initial.length() > 1) {
			long fact = MathUtils.fact(initial.length() - 1).longValue();
			int index = (int) (temp / fact);
			result = result + initial.charAt(index);
			temp = temp - (temp / fact) * fact;
			initial = initial.substring(0, index) + (index + 1 <= initial.length() ? initial.substring(index + 1) : "");
		}
		result = result + initial;
		return Long.parseLong(result);
	}
}
