package fr.mvanbesien.projecteuler.from001to020;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem015 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem015().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		List<Long> list = new ArrayList<>();
		list.add(1L);
		list.add(1L);
		for (int i = 1; i < 40; i++) {
			List<Long> list2 = new ArrayList<>();
			list2.add(1L);
			for (int j = 0; j < list.size() - 1; j++) {
				list2.add(list.get(j) + list.get(j + 1));
			}
			list2.add(1L);
			list = list2;
		}

		return list.get(list.size() / 2);
	}

}
