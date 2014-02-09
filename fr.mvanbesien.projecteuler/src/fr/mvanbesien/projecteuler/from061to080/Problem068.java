package fr.mvanbesien.projecteuler.from061to080;

import java.util.Iterator;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.PermutationIterator;

public class Problem068 implements Callable<String> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem068().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public String call() throws Exception {
		String result = "";
		int gonSize = 5;
		Integer[] values = new Integer[gonSize * 2];
		for (int i = 0; i < values.length; i++)
			values[i] = i + 1;
		Iterator<Integer[]> iterator = new PermutationIterator<>(values, values.length);
		Integer[][] matrix = new Integer[gonSize][3];
		while (iterator.hasNext()) {
			Integer[] permutation = (Integer[]) iterator.next();
			Integer refsum = null;
			boolean doLoop = true;
			for (int i = 0; i < gonSize && doLoop; i++) {
				matrix[i][0] = permutation[(gonSize + i)];
				matrix[i][1] = permutation[(i)];
				matrix[i][2] = permutation[(gonSize + i - 1) % gonSize];
				int sum = matrix[i][0] + matrix[i][1] + matrix[i][2];
				if (refsum == null)
					refsum = sum;
				else
					doLoop = refsum.intValue() == sum;
			}
			if (doLoop) {
				int minIndex = 0;
				int minValue = Integer.MAX_VALUE;
				for (int i = 0; i < gonSize; i++) {
					if (matrix[i][0] < minValue) {
						minIndex = i;
						minValue = matrix[i][0];
					}
				}
				String value = "";
				for (int i = 0; i > -gonSize; i--) {
					int segmentIndex = (minIndex + i) % gonSize;
					while (segmentIndex < 0)
						segmentIndex += gonSize;
					value += matrix[segmentIndex][0] + "" + matrix[segmentIndex][1] + "" + matrix[segmentIndex][2];
				}
				if (value.length() == 16 && value.compareTo(result) > 0)
					result = value;
			}
		}
		return result;
	}
}
