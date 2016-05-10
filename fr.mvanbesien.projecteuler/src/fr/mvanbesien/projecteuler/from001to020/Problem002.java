package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem002 implements Callable<Integer> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem002().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Integer call() throws Exception {
		int previous = 1;
		int current = 2;
		
		int evenSum = previous;
		
		while (current < 4000000) {
			int sum = previous + current;
			
			if (sum % 2 == 1) {
				evenSum += sum;
			}
			previous = current;
			current = sum;
		}

		return evenSum;
	}

}
