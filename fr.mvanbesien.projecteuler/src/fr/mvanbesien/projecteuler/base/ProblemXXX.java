package fr.mvanbesien.projecteuler.base;

import java.util.concurrent.Callable;

public class ProblemXXX implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new ProblemXXX().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
