package fr.mvanbesien.projecteuler.from081to100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Problem081 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem081().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {

		// Build the matrix
		int matrixSize = 80;
		int[][] matrix = new int[matrixSize][matrixSize];
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				Problem081.class.getResourceAsStream("/Problem081.txt")));
		int rowIndex = 0;
		while (reader.ready() && rowIndex < matrixSize) {
			String[] chunks = reader.readLine().split(",");
			for (int i = 0; i < 80; i++) {
				matrix[rowIndex][i] = Integer.parseInt(chunks[i]);
			}
			rowIndex++;
		}

		// Build temp matrix
		Integer[][] pathWeight = new Integer[matrixSize][matrixSize];
		pathWeight[0][0] = matrix[0][0];

		// Initializes temp variables
		Long result = Long.MAX_VALUE;

		// Do the process !
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if (i + 1 < matrixSize) {
					if (pathWeight[i + 1][j] == null) {
						pathWeight[i + 1][j] = pathWeight[i][j] + matrix[i + 1][j];
					} else {
						pathWeight[i + 1][j] = Math.min(pathWeight[i + 1][j], pathWeight[i][j] + matrix[i + 1][j]);
					}
				}
				if (j + 1 < matrixSize) {
					if (pathWeight[i][j + 1] == null) {
						pathWeight[i][j + 1] = pathWeight[i][j] + matrix[i][j + 1];
					} else {
						pathWeight[i][j + 1] = Math.min(pathWeight[i][j + 1], pathWeight[i][j] + matrix[i][j + 1]);
					}
				}
			}
		}

		result = (long) pathWeight[matrixSize - 1][matrixSize - 1];

		return result;
	}

}
