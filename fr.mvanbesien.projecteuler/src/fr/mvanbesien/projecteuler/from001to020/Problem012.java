package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem012 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem012().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int number = 1;
		int numbersSum = number;
		boolean run = true;

		while (run) {
			number++;
			numbersSum += number;
			int factorsNumber = 2;
			for (int i = 2; i < Math.sqrt(numbersSum) + 1 && factorsNumber <= 500; i++) {
				if (numbersSum % i == 0) {
					factorsNumber += 2;
				}
			}
			run = factorsNumber <= 500;

		}
		return (long) numbersSum;
	}

}
