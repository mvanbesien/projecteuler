package fr.mvanbesien.projecteuler.from061to080;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.GeometricalNumberUtils;

public class Problem061 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem061().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private static class GeometricalNumber {

		GeometricalNumber(long value, int type) {
			long index = -1;
			switch (type) {
			case 3:
				index = GeometricalNumberUtils.getTriangleIndex(value);
				break;
			case 4:
				index = GeometricalNumberUtils.getSquareIndex(value);
				break;
			case 5:
				index = GeometricalNumberUtils.getPentagonalIndex(value);
				break;
			case 6:
				index = GeometricalNumberUtils.getHexagonalIndex(value);
				break;
			case 7:
				index = GeometricalNumberUtils.getHeptagonalIndex(value);
				break;
			case 8:
				index = GeometricalNumberUtils.getOctogonalIndex(value);
				break;
			}
			this.value = value;
			this.index = index;
			this.type = type;
		}

		long value;
		long index;
		int type;

		@Override
		public String toString() {
			return "P(" + this.type + "," + this.index + ")=" + this.value;
		}
	}

	@Override
	public Long call() throws Exception {
		for (GeometricalNumber octo : getMatchingOctogonals(1000, 10000)) {
			List<GeometricalNumber> cycle = new ArrayList<GeometricalNumber>();
			cycle.add(octo);
			long sum = getCycle(cycle);
			if (sum > -1)
				return sum;
		}

		return null;
	}

	private long getCycle(List<GeometricalNumber> cycle) {
		// Get the cycle for which information is missing.
		List<Integer> missingIndexes = new ArrayList<>();
		for (int i = 8; i >= 3; i--) {
			boolean hasIndex = false;
			for (Iterator<GeometricalNumber> iterator = cycle.iterator(); iterator.hasNext() && !hasIndex;) {
				if (iterator.next().type == i) {
					hasIndex = true;
				}
			}
			if (!hasIndex)
				missingIndexes.add(i);
		}

		long prefix = 100 * (cycle.get(cycle.size() - 1).value % 100);
		for (int missingIndex : missingIndexes) {
			for (GeometricalNumber number : getMatchingNumber(missingIndex, prefix, prefix + 100)) {
				List<GeometricalNumber> newCycle = new ArrayList<>(cycle);
				newCycle.add(number);
				long sum = getCycle(newCycle);
				if (sum == -1) {
					if (newCycle.size() == 6 && (newCycle.get(0).value / 100 == newCycle.get(5).value % 100)) {
						boolean hasDuplicates = false;
						for (int i = 0; i < newCycle.size() && !hasDuplicates; i++) {
							for (int j = 0; j < newCycle.size() && !hasDuplicates; j++) {
								if (i != j && newCycle.get(i).index == newCycle.get(j).index)
									hasDuplicates = true;
							}
						}
						if (!hasDuplicates) {
							long newSum = 0;
							for (GeometricalNumber gn : newCycle) {
								System.out.print(gn + ", ");
								newSum += gn.value;
							}
							System.out.println("");
							return newSum;

						}
					}

				} else {
					return sum;
				}

			}
		}
		return -1;

	}

	private Set<GeometricalNumber> getMatchingOctogonals(long min, long max) {
		Set<GeometricalNumber> results = new HashSet<>();
		if (min < 1000)
			return results;
		for (long l = GeometricalNumberUtils.nextOctogonal(min - 1); l <= max && l < 10000; l = GeometricalNumberUtils
				.nextOctogonal(l)) {
			results.add(new GeometricalNumber(l, 8));
		}
		return results;
	}

	private Set<GeometricalNumber> getMatchingHeptagonals(long min, long max) {
		Set<GeometricalNumber> results = new HashSet<>();
		if (min < 1000)
			return results;
		for (long l = GeometricalNumberUtils.nextHeptagonal(min - 1); l <= max && l < 10000; l = GeometricalNumberUtils
				.nextHeptagonal(l)) {
			results.add(new GeometricalNumber(l, 7));
		}
		return results;
	}

	private Set<GeometricalNumber> getMatchingHexagonals(long min, long max) {
		Set<GeometricalNumber> results = new HashSet<>();
		if (min < 1000)
			return results;
		for (long l = GeometricalNumberUtils.nextHexagonal(min - 1); l <= max && l < 10000; l = GeometricalNumberUtils
				.nextHexagonal(l)) {
			results.add(new GeometricalNumber(l, 6));
		}
		return results;
	}

	private Set<GeometricalNumber> getMatchingPentagonals(long min, long max) {
		Set<GeometricalNumber> results = new HashSet<>();
		if (min < 1000)
			return results;
		for (long l = GeometricalNumberUtils.nextPentagonal(min - 1); l <= max && l < 10000; l = GeometricalNumberUtils
				.nextPentagonal(l)) {
			results.add(new GeometricalNumber(l, 5));
		}
		return results;
	}

	private Set<GeometricalNumber> getMatchingSquares(long min, long max) {
		Set<GeometricalNumber> results = new HashSet<>();
		if (min < 1000)
			return results;
		for (long l = GeometricalNumberUtils.nextSquare(min - 1); l <= max && l < 10000; l = GeometricalNumberUtils
				.nextSquare(l)) {
			results.add(new GeometricalNumber(l, 4));
		}
		return results;
	}

	private Set<GeometricalNumber> getMatchingTriangle(long min, long max) {
		Set<GeometricalNumber> results = new HashSet<>();
		if (min < 1000)
			return results;
		for (long l = GeometricalNumberUtils.nextTriangle(min - 1); l <= max && l < 10000; l = GeometricalNumberUtils
				.nextTriangle(l)) {
			results.add(new GeometricalNumber(l, 3));
		}
		return results;
	}

	private Set<GeometricalNumber> getMatchingNumber(int index, long min, long max) {
		switch (index) {
		case 3:
			return getMatchingTriangle(min, max);
		case 4:
			return getMatchingSquares(min, max);
		case 5:
			return getMatchingPentagonals(min, max);
		case 6:
			return getMatchingHexagonals(min, max);
		case 7:
			return getMatchingHeptagonals(min, max);
		case 8:
			return getMatchingOctogonals(min, max);
		default:
			return new HashSet<>();
		}
	}
}

