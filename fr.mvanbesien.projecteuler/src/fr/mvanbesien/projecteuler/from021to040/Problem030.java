package fr.mvanbesien.projecteuler.from021to040;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class Problem030 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem030().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger lowLimit = BigInteger.valueOf(1);
		for (int i = 0; i <= 9; i++) {
			BigInteger ai = BigInteger.valueOf(i).pow(5);
			BigInteger bi = BigInteger.valueOf(100000 * i);
			for (int j = 0; j <= 9; j++) {
				BigInteger aj = BigInteger.valueOf(j).pow(5).add(ai);
				BigInteger bj = BigInteger.valueOf(10000 * j).add(bi);
				for (int k = 0; k <= 9; k++) {
					BigInteger ak = BigInteger.valueOf(k).pow(5).add(aj);
					BigInteger bk = BigInteger.valueOf(1000 * k).add(bj);
					for (int l = 0; l <= 9; l++) {
						BigInteger al = BigInteger.valueOf(l).pow(5).add(ak);
						BigInteger bl = BigInteger.valueOf(100 * l).add(bk);
						for (int m = 0; m <= 9; m++) {
							BigInteger am = BigInteger.valueOf(m).pow(5).add(al);
							BigInteger bm = BigInteger.valueOf(10 * m).add(bl);
							for (int n = 0; n <= 9; n++) {
								BigInteger an = BigInteger.valueOf(n).pow(5).add(am);
								BigInteger bn = BigInteger.valueOf(n).add(bm);
								if (bn.equals(an) && bn.compareTo(lowLimit) > 0) {
									System.out.println(an);
									sum = sum.add(an);
								}
							}
						}
					}
				}
			}
		}
		return sum.toString();
	}

}
