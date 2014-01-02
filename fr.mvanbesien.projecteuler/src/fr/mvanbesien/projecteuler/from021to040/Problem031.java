package fr.mvanbesien.projecteuler.from021to040;

import java.util.concurrent.Callable;

public class Problem031 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem031().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		int comb = 0;
		for (int l2 = 0; l2 <= 1; l2++) {
			int sumL2 = 200 * l2;
			for (int l1 = 0; l1 <= 2 && sumL2 <= 200; l1++) {
				int sumL1 = sumL2 + 100 * l1;
				for (int p50 = 0; p50 <= 4 && sumL1 <= 200; p50++) {
					int sumP50 = sumL1 + 50 * p50;
					for (int p20 = 0; p20 <= 10 && sumP50 <= 200; p20++) {
						int sumP20 = sumP50 + 20 * p20;
						for (int p10 = 0; p10 <= 20 && sumP20 <= 200; p10++) {
							int sumP10 = sumP20 + 10 * p10;
							for (int p5 = 0; p5 <= 40 && sumP10 <= 200; p5++) {
								int sumP5 = sumP10 + 5 * p5;
								for (int p2 = 0; p2 <= 100 && sumP5 <= 200; p2++) {
									int sumP2 = sumP5 + 2 * p2;
									for (int p1 = 0; p1 <= 200 && sumP2 <= 200; p1++) {
										int sumP1 = sumP2 + p1;
										if (sumP1 == 200) {
											comb++;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return (long) comb;
	}

}
