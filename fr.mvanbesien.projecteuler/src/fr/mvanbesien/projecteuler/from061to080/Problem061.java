package fr.mvanbesien.projecteuler.from061to080;

import java.util.concurrent.Callable;

public class Problem061 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem061().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
