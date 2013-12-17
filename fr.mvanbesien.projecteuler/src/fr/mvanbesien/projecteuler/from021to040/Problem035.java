package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem035 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem035().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long count = 1;
		for (int i = 3; i < 1000000; i = i + 2) {

			String s = String.valueOf(i);
			// First case important, as if such can be found, it will one day
			// reach the end, and it is even :)
			boolean isCircularPrime = s.indexOf("2") == -1 && s.indexOf("4") == -1 && s.indexOf("6") == -1
					&& s.indexOf("8") == -1 && s.indexOf("0") == -1 && isPrime(i);

			String temp = s.substring(1) + s.substring(0, 1);
			while (!temp.equals(s) && isCircularPrime) {
				isCircularPrime = isPrime(Long.parseLong(temp));
				temp = temp.substring(1) + temp.substring(0, 1);

			}
			if (isCircularPrime) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPrime(long l) {
		if (l < 3)
			return true;
		if (l % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(l) + 1; i = i + 2) {
			if (l % i == 0)
				return false;
		}
		return true;
	}

}
