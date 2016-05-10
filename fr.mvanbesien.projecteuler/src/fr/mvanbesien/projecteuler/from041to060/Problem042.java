package fr.mvanbesien.projecteuler.from041to060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Problem042 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem042().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				Problem042.class.getResourceAsStream("/Problem042.txt")));
		long count = 0;
		while (reader.ready()) {
			String[] words = reader.readLine().replace("\"", "").toUpperCase().split(",");
			for (String word : words) {
				if (isTriangle(word)) {
					count++;
				}
			}
		}
		reader.close();
		return count;
	}

	private boolean isTriangle(String word) {
		int wordCount = 0;
		for (char c : word.toCharArray()) {
			wordCount += (c - 'A' + 1);
		}
		int n = 0;
		while (true) {
			int triangle = (n * (n + 1)) / 2;
			if (triangle == wordCount)
				return true;
			else if (triangle > wordCount)
				return false;
			n++;
		}
	}

}
