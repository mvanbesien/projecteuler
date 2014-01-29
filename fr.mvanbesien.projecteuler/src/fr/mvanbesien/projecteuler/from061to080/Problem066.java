package fr.mvanbesien.projecteuler.from061to080;

import java.util.concurrent.Callable;

// http://projecteuler.net/problem=64
// http://fr.wikipedia.org/wiki/%C3%89quation_de_Pell-Fermat#Cas_x.C2.B2-ny.C2.B2_.3D_1
public class Problem066 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem066().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
