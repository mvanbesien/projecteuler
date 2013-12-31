package fr.mvanbesien.projecteuler.from041to060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Problem059 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem059().call());
		System.out.println(String.format("Executed in %d �s", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		// Load the file && get the message as char array.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
				Problem059.class.getResourceAsStream("/Problem059.txt")));

		String[] chunks = bufferedReader.readLine().split(",");
		char[] chars = new char[chunks.length];
		for (int i = 0; i < chunks.length; i++) {
			chars[i] = (char) Integer.parseInt(chunks[i]);
		}
		bufferedReader.close();
		char[] result = null;

		for (char a = 'a'; a <= 'z' && result == null; a++) {
			boolean aValid = true;
			for (char b = 'a'; b <= 'z' && aValid && result == null; b++) {
				boolean bValid = true;
				for (char c = 'a'; c <= 'z' && bValid&& result == null; c++) {
					char[] key = { a, b, c };
					char[] decrypted = new char[chars.length];
					boolean cValid = true;
					for (int i = 0; i < chars.length && cValid&& result == null; i++) {
						int k = i % key.length;
						char r = (char) (chars[i] ^ key[k]);
						decrypted[i] = r;
						if (r >= 32 && r <= 122) {
						} else {
							if (k < 1) {
								aValid = false;
								bValid = false;
								cValid = false;
								a++;
							} else if (k < 2) {
								bValid = false;
								cValid = false;
								b++;
							} else {
								cValid = false;
							}
						}
					}
					if (cValid) {
						result = decrypted;
					}
				}
			}
		}
		long sum = 0;
		for (char c : result)
			sum += (int) c;
		return sum;
	}
}
