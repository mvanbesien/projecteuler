package fr.mvanbesien.projecteuler.from081to100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem097 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem097().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private static final class PowerAndSuffix {

		private final Long power;

		private final BigInteger suffix;

		public PowerAndSuffix(Long power, BigInteger suffix) {
			this.power = power;
			this.suffix = suffix;
		}

		@Override
		public String toString() {
			return "2^" + power + " -> " + suffix;
		}
	}

	@Override
	public Long call() throws Exception {

		
		// 28433×2^7830457+1 / Get the last 10 digits

		// Start with the power of two...
		List<PowerAndSuffix> powers = new ArrayList<PowerAndSuffix>();
		BigInteger radical = BigInteger.valueOf(2);
		BigInteger limitation = BigInteger.valueOf((long) Math.pow(10, 10));
		powers.add(new PowerAndSuffix(1L, radical));

		for (long power = 1; power < 7830457;) {
			// Locate the highest stored power of two that leads to result lower to the target.
			PowerAndSuffix ps = null;
			for (Iterator<PowerAndSuffix> iterator = powers.iterator(); iterator.hasNext() && ps == null;) {
				PowerAndSuffix next = iterator.next();
				if (power + next.power <= 7830457) {
					ps = next;
				}
			}
			// When found, perform the multiplication & restrain to 10 last figures
			radical = radical.multiply(ps.suffix).mod(limitation);
			
			// Store newly found value & prepare for next iteration.
			power += ps.power;
			powers.add(0, new PowerAndSuffix(power, radical));
		}

		// Perform end of computation & returns.
		return radical.multiply(BigInteger.valueOf(28433)).mod(limitation).add(BigInteger.ONE).longValue();
	}

}
