package fr.mvanbesien.projecteuler.from001to020;

import java.util.Calendar;
import java.util.concurrent.Callable;

public class Problem019 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem019().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Calendar c = Calendar.getInstance();
		int numberOfSundays = 0;
		c.set(Calendar.YEAR, 1901);
		c.set(Calendar.MONTH, 1);
		c.set(Calendar.DAY_OF_MONTH, 1);

		while (c.get(Calendar.YEAR) < 2001) {
			if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				numberOfSundays++;
			c.add(Calendar.MONTH, 1);
		}

		return (long) numberOfSundays;
	}

}
