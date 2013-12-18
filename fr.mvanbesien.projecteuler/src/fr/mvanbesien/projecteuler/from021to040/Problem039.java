package fr.mvanbesien.projecteuler.from021to040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class Problem039 implements Callable<Long> {

	private static class Triplet {
		int a, b, c;

		public Triplet(int i, int j, int k) {
			int[] values = new int[] { i, j, k };
			Arrays.sort(values);
			a = values[0];
			b = values[1];
			c = values[2];
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Triplet))
				return false;
			Triplet other = (Triplet) obj;
			return other.a == this.a && other.b == this.b && other.c == this.c;

		}

		@Override
		public int hashCode() {
			return ("" + a + "/" + b + "/" + c).hashCode();
		}

		@Override
		public String toString() {
			return "{" + a + "," + b + "," + c + "}";
		}
	}

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem039().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	@Override
	public Long call() throws Exception {
		Map<Integer, Collection<Triplet>> allPossibilities = new HashMap<>();
		for (int i = 1; i <= 1000; i++) {
			for (int j = 1; j <= i; j++) {
				Integer k = getTrueSquare(i * i + j * j);
				if (k != null) {
					int perimeter = i + j + k;
					if (perimeter <= 1000) {
						Triplet t = new Triplet(i, j, k);
						Collection<Triplet> collection = allPossibilities.get(perimeter);
						if (collection == null) {
							collection = new ArrayList<>();
							allPossibilities.put(perimeter, collection);
						}
						if (!collection.contains(t))
							collection.add(t);
					}
				}
			}
		}

		long keyMax = 0;
		int valueMax = 0;
		for (int perimeter : allPossibilities.keySet()) {
			Collection<Triplet> triplets = allPossibilities.get(perimeter);
			int size = triplets != null ? triplets.size() : 0;
			if (size > valueMax) {
				keyMax = perimeter;
				valueMax = size;
			}
		}

		return keyMax;
	}

	private Integer getTrueSquare(int sqk) {
		int flooredSquareRoot = (int) Math.sqrt(sqk);
		return flooredSquareRoot * flooredSquareRoot == sqk ? flooredSquareRoot : null;
	}

}
