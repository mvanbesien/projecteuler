package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.Fraction;

public class Problem033 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem033().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Fraction f = new Fraction(1, 1);
		for (int x = 1; x < 10; x++) {
			for (int a = 1; a < 10 && a != x; a++) {
				for (int b = 1; b < 10 && b != x; b++) {
					// Pattern is xa/bx (a/b) or ax/xb (a/b)...
					int xa = 10 * x + a;
					int ax = 10 * a + x;
					int xb = 10 * x + b;
					int bx = 10 * b + x;
					if (xa < bx && xa * b == bx * a) {
						f = Fraction.multiply(f, new Fraction(xa, bx));
					} else if (ax < xb && ax * b == xb * a) {
						f = Fraction.multiply(f, new Fraction(ax, xb));
					}
				}
			}
		}
		return (long) f.getDenominator();
	}

}
