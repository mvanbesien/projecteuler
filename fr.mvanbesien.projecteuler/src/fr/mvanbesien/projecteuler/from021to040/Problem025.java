package fr.mvanbesien.projecteuler.from021to040;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.concurrent.Callable;

public class Problem025 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem025().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Fibonacci fibo = new Fibonacci();
		boolean go = true;
		while (go) {
			BigInteger bi = fibo.next();
			go = bi.toString().length() < 1000;
		}
		return (long) fibo.getIndex();
	}

	private static final class Fibonacci implements Iterator<BigInteger> {

		private BigInteger i = BigInteger.valueOf(1);
		private BigInteger j = BigInteger.valueOf(1);
		private int index = 0;

		public int getIndex() {
			return index;
		}

		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public BigInteger next() {
			if (index < 2) {
				index++;
				return i;
			} else {
				BigInteger k = j.add(i);
				index++;
				i = j;
				j = k;
				return k;
			}

		}

		@Override
		public void remove() {
		}

	}

}
