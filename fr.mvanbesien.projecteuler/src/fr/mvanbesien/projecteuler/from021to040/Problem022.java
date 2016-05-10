package fr.mvanbesien.projecteuler.from021to040;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class Problem022 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem022().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		String line = new BufferedReader(new InputStreamReader(Problem022.class.getResourceAsStream("/Problem022.txt")))
				.readLine();
		String[] names = line.replace("\"", "").split(",");
		List<String> namesList = new ArrayList<String>(Arrays.asList(names));
		Collections.sort(namesList);
		names = namesList.toArray(names);

		long sum = 0;

		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			long nameSum = 0;
			for (int j = 0; j < name.length(); j++) {
				nameSum += name.charAt(j) - 'A' + 1;
			}
			sum = sum + nameSum * (i + 1);
		}
		return (long) sum;
	}
}
