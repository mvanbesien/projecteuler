package fr.mvanbesien.projecteuler.utils;

public class GeometricalNumberUtils {

	// Triangles

	public static long getTriangle(long value) {
		return value * (value + 1) / 2;
	}

	public static long getTriangleIndex(long value) {
		return (long) (-1 + Math.sqrt(1 + 8 * value)) / 2;
	}

	public static long nextTriangle(long value) {
		return getTriangle(getTriangleIndex(value) + 1);
	}

	public static boolean isTriangle(long value) {
		return value <= 1 ? false : getTriangle(getTriangleIndex(value)) == value;
	}

	// Squares

	public static long getSquare(long value) {
		return value * value;
	}

	public static long getSquareIndex(long value) {
		return (long) Math.sqrt(value);
	}

	public static long nextSquare(long value) {
		return getSquare(getSquareIndex(value) + 1);
	}

	public static boolean isSquare(long value) {
		return getSquare(getSquare(value)) == value;
	}

	// Pentagonals

	public static long getPentagonal(long value) {
		return value * (3 * value - 1) / 2;
	}

	public static long getPentagonalIndex(long value) {
		return (long) (1 + Math.sqrt(1 + 24 * value)) / 6;
	}

	public static boolean isPentagonal(long value) {
		return value <= 1 ? false : getPentagonal(getPentagonalIndex(value)) == value;
	}

	public static long nextPentagonal(long value) {
		return getPentagonal(getPentagonalIndex(value) + 1);
	}

	// Hexagonals

	public static long getHexagonal(long value) {
		return value * (2 * value - 1);
	}

	public static long getHexagonalIndex(long value) {
		return (long) (1 + Math.sqrt(1 + 8 * value)) / 4;
	}

	public static boolean isHexagonal(long value) {
		return getHexagonal(getHexagonalIndex(value)) == value;
	}

	public static long nextHexagonal(long value) {
		return getHexagonal(getHexagonalIndex(value) + 1);
	}

	// Heptagonals

	public static long getHeptagonal(long value) {
		return value * (5 * value - 3) / 2;
	}

	public static long getHeptagonalIndex(long value) {
		return (long) (3 + Math.sqrt(9 + 40 * value)) / 10;
	}

	public static long nextHeptagonal(long value) {
		return getHeptagonal(getHeptagonalIndex(value) + 1);
	}

	public static boolean isHeptagonal(long value) {
		return getHeptagonal(getHeptagonalIndex(value)) == value;
	}

	// Octogonals

	public static long getOctogonal(long value) {
		return value * (3 * value - 2);
	}

	public static long getOctogonalIndex(long value) {
		return (long) (2 + Math.sqrt(4 + 12 * value)) / 6;
	}

	public static long nextOctogonal(long value) {
		return getOctogonal(getOctogonalIndex(value) + 1);
	}

	public static boolean isOctogonal(long value) {
		return getOctogonal(getOctogonalIndex(value)) == value;
	}
}
