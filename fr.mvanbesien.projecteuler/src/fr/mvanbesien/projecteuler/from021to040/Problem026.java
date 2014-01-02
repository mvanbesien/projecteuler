package fr.mvanbesien.projecteuler.from021to040;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem026 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem026().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private static int getCycle(int j) {
		List<Integer> reminders = new ArrayList<Integer>();

		int temp = 1;
		boolean loop = true;

		while (loop) {
			while (temp < j) {
				temp = temp * 10;
			}
			int reminder = temp % j;
			if (reminder == 0) {
				loop = false;
			} else {
				if (reminders.contains(reminder)) {
					return reminders.size() - reminders.lastIndexOf(reminder);
				} else {
					reminders.add(temp % j);
				}
			}
			temp = reminder;
		}
		return 0;
	}

	@Override
	public Long call() throws Exception {
		int maxCycle = 0;
		int value = 0;
		for (int i = 2; i < 1000; i++) {
			int cycle = getCycle(i);
			if (maxCycle < cycle) {
				maxCycle = cycle;
				value = i;
			}
		}
		return (long) value;
	}

}
