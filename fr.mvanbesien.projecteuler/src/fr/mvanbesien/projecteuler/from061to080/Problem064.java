package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem064 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem064().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;

		for (int value = 2; value < 10000; value++) {
			List<String> reminders = new ArrayList<>();
			int a1 = 1;
			int b1 = (int) Math.sqrt(value);
			int c1 = value - b1 * b1;
			boolean loop = b1 * b1 != value;
			while (loop) {

				String s = a1 + "," + b1 + "," + c1;

				if (reminders.contains(s)) {
					int seq = reminders.size() - reminders.indexOf(s);
					sum += seq % 2;
					loop = false;
				} else {

					reminders.add(s);

					int entier = (int) (a1 * (Math.sqrt(value) + b1) / c1);
					int a2 = c1;
					int b2 = -(b1 - c1 * entier);
					int c2 = a1 * (value - b2 * b2);

					int pgcd = BigInteger.valueOf(a2).gcd(BigInteger.valueOf(c2)).intValue();

					a1 = a2 / pgcd;
					b1 = b2;
					c1 = c2 / pgcd;
				}
			}

		}
		return sum;
	}
}
