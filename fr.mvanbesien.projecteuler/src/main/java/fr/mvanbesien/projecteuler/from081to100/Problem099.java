package fr.mvanbesien.projecteuler.from081to100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Problem099 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem099().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(Problem099.class.getResourceAsStream("/Problem099.txt")));

		long lineNumber = 0;
		long maxLineNumber = 0;
		double currentMax = 0;
		while (reader.ready()) {
			String[] line = reader.readLine().split(",");
			lineNumber++;
			double length = getLength(line);
			if (length > currentMax) {
				currentMax = length;
				maxLineNumber = lineNumber;
			}
		}

		return maxLineNumber;
	}

	private double getLength(String[] values) {
		return (1 + Integer.parseInt(values[1]) * Math.log10(Integer.parseInt(values[0])));
	}

}
