package fr.mvanbesien.projecteuler.from001to020;

import java.util.concurrent.Callable;

public class Problem018 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem018().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		String[] values = new String[] { "75", "95 64", "17 47 82", "18 35 87 10", "20 04 82 47 65",
				"19 01 23 75 03 34", "88 02 77 73 07 63 67", "99 65 04 28 06 16 70 92", "41 41 26 56 83 40 80 70 33",
				"41 48 72 33 47 32 37 16 94 29", "53 71 44 65 25 43 91 52 97 51 14",
				"70 11 33 28 77 73 17 78 39 68 17 57", "91 71 52 38 17 14 91 43 58 50 27 29 48",
				"63 66 04 68 89 53 67 30 73 16 69 87 40 31", "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23" };

		int[][] matrix = new int[values.length][values.length];

		// First fill of the matrix
		for (int i = 0; i < values.length; i++) {
			String[] chunks = values[i].split(" ");
			for (int j = 0; j < chunks.length; j = j + 1) {
				matrix[i][j] = Integer.parseInt(chunks[j]);
			}
		}

		// Cascade all the values
		for (int i = 1; i < values.length; i++) {
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
		for (int i = 0; i < values.length; i++) {
			if (matrix[values.length - 1][i] > max)
				max = matrix[values.length - 1][i];
		}
		return (long) max;
	}

}
