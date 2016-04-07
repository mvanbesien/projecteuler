package fr.mvanbesien.projecteuler.from081to100;

import java.util.concurrent.Callable;

public class Problem086 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem086().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		int base = 1;
		int count = 1;
		while (true) {
			for (int a = 1; a <= base; a++) {
				for (int b = a; b <= base; b++) {
					int diag = diag(a, b, base);
					if (isSquare(diag)) {
						count++;
						if (count > 1000000) {
							return (long) base;
						}
					}
				}
			}
			base++;
		}
	}

	private int diag(int a, int b, int c) {
		return ((a + b) * (a + b) + c * c);
	}

	private boolean isSquare(int dd) {
		int d = (int) Math.sqrt(dd);
		return d * d == dd;
	}

}
