package fr.mvanbesien.projecteuler.from041to060;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem043 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem043().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		long sum = 0;
		for (int d4 : new int[] { 0, 2, 4, 6, 8 }) {
			for (int d6 : (d4 == 0 ? new int[] { 5 } : new int[] { 0, 5 })) {
				for (int d5 : getValues(new int[] { d4, d6 })) {
					for (int d3 : getD3Values(d4, d5, new int[] { d4, d5, d6 })) {
						for (int d7 : getD7Values(d5, d6, new int[] { d3, d4, d5, d6 })) {
							for (int d8 : getD8Values(d6, d7, new int[] { d3, d4, d5, d6, d7 })) {
								for (int d9 : getD9Values(d7, d8, new int[] { d3, d4, d5, d6, d7, d8 })) {
									for (int d10 : getD10Values(d8, d9, new int[] { d3, d4, d5, d6, d7, d8, d9 })) {
										for (int d1 : getValues(new int[] { d3, d4, d5, d6, d7, d8, d9, d10 })) {
											for (int d2 : getValues(new int[] { d1, d3, d4, d5, d6, d7, d8, d9, d10 })) {
												long l = Long.parseLong("" + d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9
														+ d10);
												sum +=l;
											}
										}
									}
								}
							}
						}
					}
				}
			}

		}
		return sum;
	}

	private List<Integer> getD10Values(int d8, int d9, int[] forbiddenValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (!contains(forbiddenValues, i) && (100 * d8 + 10 * d9 + i) % 17 == 0) {
				list.add(i);
			}
		}
		return list;
	}

	private List<Integer> getD9Values(int d7, int d8, int[] forbiddenValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (!contains(forbiddenValues, i) && (100 * d7 + 10 * d8 + i) % 13 == 0) {
				list.add(i);
			}
		}
		return list;
	}

	private List<Integer> getD8Values(int d6, int d7, int[] forbiddenValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (!contains(forbiddenValues, i) && (100 * d6 + 10 * d7 + i) % 11 == 0) {
				list.add(i);
			}
		}
		return list;
	}

	private List<Integer> getD7Values(int d5, int d6, int[] forbiddenValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (!contains(forbiddenValues, i) && (100 * d5 + 10 * d6 + i) % 7 == 0) {
				list.add(i);
			}
		}
		return list;
	}

	private List<Integer> getValues(int[] forbiddenValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (!contains(forbiddenValues, i))
				list.add(i);
		}
		return list;
	}

	private boolean contains(int[] forbiddenValues, int i) {
		for (int t : forbiddenValues)
			if (i == t)
				return true;
		return false;
	}

	private List<Integer> getD3Values(int d4, int d5, int[] forbiddenValues) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (!contains(forbiddenValues, i) && (i + d4 + d5) % 3 == 0)
				list.add(i);
		}
		return list;
	}
}
