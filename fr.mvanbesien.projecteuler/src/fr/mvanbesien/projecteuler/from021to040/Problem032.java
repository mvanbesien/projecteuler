package fr.mvanbesien.projecteuler.from021to040;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

public class Problem032 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem032().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Collection<Long> products = new ArrayList<Long>();
		long max = 1000000000;
		for (int i = 1; i < Math.sqrt(max) + 1; i++) {
			for (int j = 1; j < (Math.sqrt(max) / i) + 1; j++) {
				String si = String.valueOf(i);
				String sj = String.valueOf(j);
				String sk = String.valueOf(i * j);
				String all = si + sj + sk;
				if (all.length() == 9) {
					boolean ok = true;
					for (int k = 1; k <= 9 && ok; k++) {
						ok = all.indexOf("" + k) > -1;

					}
					if (ok) {
						Long result = new Long(i * j);
						if (!products.contains(result)) {
							products.add(result);
						}
					}
				}
			}
		}
		long sum = 0;
		for (Long product : products)
			sum += product;
		return sum;
	}

}
