package fr.mvanbesien.projecteuler.from061to080;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Problem067 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem067().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		int[][] matrix = new int[100][100];

		// First fill of the matrix
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				Problem067.class.getResourceAsStream("/Problem067.txt")));
		for (int i = 0; i < 100; i++) {
			String[] chunks = reader.readLine().split(" ");
			for (int j = 0; j < chunks.length; j = j + 1) {
				matrix[i][j] = Integer.parseInt(chunks[j]);
			}
		}

		// Cascade all the values
		for (int i = 1; i < 100; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j];
				} else if (j == i) {
					matrix[i][j] = matrix[i - 1][j - 1] + matrix[i][j];
				} else {
					matrix[i][j] = matrix[i][j]
							+ (matrix[i - 1][j - 1] > matrix[i - 1][j] ? matrix[i - 1][j - 1] : matrix[i - 1][j]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < 100; i++) {
			if (matrix[99][i] > max)
				max = matrix[99][i];
		}
		return (long) max;
	}

}
