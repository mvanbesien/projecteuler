package fr.mvanbesien.projecteuler.from061to080;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.BigFraction;

// http://projecteuler.net/problem=64
// http://fr.wikipedia.org/wiki/%C3%89quation_de_Pell-Fermat#Cas_x.C2.B2-ny.C2.B2_.3D_1
public class Problem066 implements Callable<Long> {

	private static class Development {
		int integer;
		List<Integer> fracParts = new ArrayList<>();

		BigFraction getFraction() {
			int m = fracParts.size();
			int rank = m % 2 == 0 ? m - 1 : 2 * m - 1;
			BigFraction fraction = new BigFraction(BigInteger.ZERO, BigInteger.ONE);
			for (int i = rank; i > 0; i--) {
				int frac = fracParts.get((i - 1) % m);
				fraction = fraction.add(new BigFraction(BigInteger.valueOf(frac), BigInteger.ONE)).invert();
			}
			fraction = fraction.add(new BigFraction(BigInteger.valueOf(integer), BigInteger.ONE));

			return fraction;
		}
	}

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem066().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		int maxN = 0;
		BigInteger maxX = BigInteger.ZERO;
		
		for (int n = 1; n <= 1000; n++) {
			Development development = this.develop(n);
			if (development.fracParts.size() > 0) {
				BigInteger x = development.getFraction().getNumerator();
				if (x.compareTo(maxX) > 0) {
					maxN = n;
					maxX = x;
				}
				
			}
		}
		return (long) maxN;
	}

	private Development develop(int n) {
		List<String> reminders = new ArrayList<>();
		Development development = new Development();

		int a1 = 1;
		int b1 = (int) Math.sqrt(n);
		int c1 = n - b1 * b1;
		development.integer = b1;

		boolean loop = c1 != 0;
		while (loop) {

			String s = a1 + "," + b1 + "," + c1;

			if (reminders.contains(s)) {
				loop = false;
			} else {

				reminders.add(s);

				int entier = (int) (a1 * (Math.sqrt(n) + b1) / c1);
				development.fracParts.add(entier);
				int a2 = c1;
				int b2 = -(b1 - c1 * entier);
				int c2 = a1 * (n - b2 * b2);

				int pgcd = BigInteger.valueOf(a2).gcd(BigInteger.valueOf(c2)).intValue();

				a1 = a2 / pgcd;
				b1 = b2;
				c1 = c2 / pgcd;
			}
		}

		return development;
	}

}
