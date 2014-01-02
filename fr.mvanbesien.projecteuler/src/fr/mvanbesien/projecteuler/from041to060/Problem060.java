package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.MathUtils;

public class Problem060 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem060().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		long max = 9000; // Number increased as per null results... 1000, 2000
							// and finally 9000

		for (long prime1 = MathUtils.nextPrime(5); prime1 < max; prime1 = MathUtils.nextPrime(prime1)) {
			for (long prime2 = MathUtils.nextPrime(prime1); prime2 < max; prime2 = MathUtils.nextPrime(prime2)) {
				if (concatenationsPrimes(new long[] { prime1 }, new long[] { prime2 })) {
					for (long prime3 = MathUtils.nextPrime(prime2); prime3 < max; prime3 = MathUtils.nextPrime(prime3)) {
						if (concatenationsPrimes(new long[] { prime1, prime2 }, new long[] { prime3 })) {
							for (long prime4 = MathUtils.nextPrime(prime3); prime4 < max; prime4 = MathUtils
									.nextPrime(prime4)) {
								if (concatenationsPrimes(new long[] { prime1, prime2, prime3 }, new long[] { prime4 })) {
									for (long prime5 = MathUtils.nextPrime(prime4); prime5 < max; prime5 = MathUtils
											.nextPrime(prime5)) {
										if (concatenationsPrimes(new long[] { prime1, prime2, prime3, prime4 },
												new long[] { prime5 })) {
											return prime1 + prime2 + prime3 + prime4 + prime5;
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return null;
	}

	private boolean concatenationsPrimes(long[] firsts, long[] seconds) {
		for (int i = 0; i < firsts.length; i++) {
			for (int j = 0; j < seconds.length; j++) {
				if (!MathUtils.isPrime(Long.parseLong("" + firsts[i] + seconds[j])))
					return false;
				if (!MathUtils.isPrime(Long.parseLong("" + seconds[j] + firsts[i])))
					return false;
			}
		}
		return true;
	}

}
