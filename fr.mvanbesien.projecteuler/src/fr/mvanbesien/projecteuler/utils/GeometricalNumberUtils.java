package fr.mvanbesien.projecteuler.utils;

public class GeometricalNumberUtils {

	public static long nextHexagonal(long value) {
		long x = (long) (1 + Math.sqrt(1 + 8 * value)) / 4;
		return (x + 1) * (2 * (x + 1) - 1);
	}

	public static long nextTriangle(long value) {
		long x = (long) (-1 + Math.sqrt(1 + 8 * value)) / 2;
		return (x + 1) * (x + 1 + 1) / 2;
	}

	public static long nextPentagonal(long value) {
		long x = (long) (1 + Math.sqrt(1 + 24 * value)) / 6;
		return getPentagonal(x + 1);
	}

	public static long getPentagonal(long value) {
		return value * (3 * value - 1) / 2;
	}

	public static boolean isPentagonal(long value) {
		if (value <= 1)
			return false;
		long x = (long) (1 + Math.sqrt(1 + 24 * value)) / 6;
		return getPentagonal(x) == value;
	}

}
