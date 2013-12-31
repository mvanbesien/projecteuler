package fr.mvanbesien.projecteuler.from041to060;

import java.util.concurrent.Callable;

public class Problem060 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem060().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		long max = 9000; // Number increased as per null results... 1000, 2000 and finally 9000

		for (long prime1 = nextPrime(5); prime1 < max; prime1 = nextPrime(prime1)) {
			for (long prime2 = nextPrime(prime1); prime2 < max; prime2 = nextPrime(prime2)) {
				if (concatenationsPrimes(new long[] { prime1 }, new long[] { prime2 })) {
					for (long prime3 = nextPrime(prime2); prime3 < max; prime3 = nextPrime(prime3)) {
						if (concatenationsPrimes(new long[] { prime1, prime2 }, new long[] { prime3 })) {
							for (long prime4 = nextPrime(prime3); prime4 < max; prime4 = nextPrime(prime4)) {
								if (concatenationsPrimes(new long[] { prime1, prime2, prime3 }, new long[] { prime4 })) {
									for (long prime5 = nextPrime(prime4); prime5 < max; prime5 = nextPrime(prime5)) {
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
				if (!isPrime(Long.parseLong("" + firsts[i] + seconds[j])))
					return false;
				if (!isPrime(Long.parseLong("" + seconds[j] + firsts[i])))
					return false;
			}
		}
		return true;
	}

	private long nextPrime(long i) {
		long temp = i + (i % 2 == 0 ? 1 : 2);
		while (!isPrime(temp)) {
			temp += 2;
		}
		return temp;
	}

	private boolean isPrime(long value) {
		if (value > 2 && value % 2 == 0)
			return false;
		for (int i = 3; i <= (int) Math.sqrt(value) + 1; i = i + 2) {
			if (value % i == 0)
				return false;
		}
		return true;
	}

}
