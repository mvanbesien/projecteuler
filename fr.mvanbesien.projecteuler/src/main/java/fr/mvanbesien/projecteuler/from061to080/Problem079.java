package fr.mvanbesien.projecteuler.from061to080;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

/*
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters;
 * the expected reply would be: 317.

 The text file, keylog.txt, 
 contains fifty successful login attempts.

 Given that the three characters are always asked for in order,
 analyse the file so as to determine the shortest possible secret passcode of unknown length.
 */

public class Problem079 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem079().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		InputStream stream = Problem079.class.getResourceAsStream("/Problem079.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		Set<String> attempts = new LinkedHashSet<>();

		while (reader.ready()) {
			attempts.add(reader.readLine().trim());
		}
		Set<Integer> appearances = new HashSet<>();
		Map<Integer, Set<Integer>> afters = new HashMap<>();
		for (int i = 0; i < 10; i++) {

			Set<Integer> after = new HashSet<>();
			for (String attempt : attempts) {
				int[] values = getChunks(attempt);
				appearances.add(values[0]);
				appearances.add(values[1]);
				appearances.add(values[2]);
				if (values[0] == i) {
					after.add(values[1]);
					after.add(values[2]);
				} else if (values[1] == i) {
					after.add(values[2]);
				}
			}
			afters.put(i, after);

		}

		String combination = "";
		for (int i = appearances.size(); i >= 0; i--) {
			for (Entry<Integer, Set<Integer>> entry : afters.entrySet()) {
				if (entry.getValue().size() == i && appearances.contains(entry.getKey())) {
					combination = combination + entry.getKey();
					continue;
				}
			}
		}

		return combination;
	}

	private int[] getChunks(String attempt) {
		int[] i = new int[attempt.length()];
		for (int j = 0; j < attempt.length(); j++) {
			i[j] = attempt.charAt(j) - '0';
		}
		return i;
	}

}
