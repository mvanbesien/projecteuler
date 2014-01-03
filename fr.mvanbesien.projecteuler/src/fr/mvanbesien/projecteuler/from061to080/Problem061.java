package fr.mvanbesien.projecteuler.from061to080;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import fr.mvanbesien.projecteuler.utils.GeometricalNumberUtils;

public class Problem061 implements Callable<Long> {

	public static void main(String[] args) throws Exception {
		long nanotime = System.nanoTime();
		System.out.println("Answer is " + new Problem061().call());
		System.out.println(String.format("Executed in %d µs", (System.nanoTime() - nanotime) / 1000));
	}

	private static final class Number {

		Number(long index, long value) {
			this.index = index;
			this.value = value;
		}

		private long index;
		private long value;
		
	}

	@Override
	public Long call() throws Exception {

		List<Number> triangles = new ArrayList<>();
		for (long l = GeometricalNumberUtils.getTriangleIndex(1000); GeometricalNumberUtils.getTriangle(l) < 10000; l++)
			triangles.add(new Number(l, GeometricalNumberUtils.getTriangle(l)));
		List<Number> squares = new ArrayList<>();
		for (long l = GeometricalNumberUtils.getSquareIndex(1000); GeometricalNumberUtils.getSquare(l) < 10000; l++)
			squares.add(new Number(l, GeometricalNumberUtils.getSquare(l)));
		List<Number> pentas = new ArrayList<>();
		for (long l = GeometricalNumberUtils.getPentagonalIndex(1000); GeometricalNumberUtils.getPentagonal(l) < 10000; l++)
			pentas.add(new Number(l, GeometricalNumberUtils.getPentagonal(l)));
		List<Number> hexas = new ArrayList<>();
		for (long l = GeometricalNumberUtils.getHexagonalIndex(1000); GeometricalNumberUtils.getHexagonal(l) < 10000; l++)
			hexas.add(new Number(l, GeometricalNumberUtils.getHexagonal(l)));
		List<Number> heptas = new ArrayList<>();
		for (long l = GeometricalNumberUtils.getHeptagonalIndex(1000); GeometricalNumberUtils.getHeptagonal(l) < 10000; l++)
			heptas.add(new Number(l, GeometricalNumberUtils.getHeptagonal(l)));
		List<Number> octas = new ArrayList<>();
		for (long l = GeometricalNumberUtils.getOctogonalIndex(1000); GeometricalNumberUtils.getOctogonal(l) < 10000; l++)
			octas.add(new Number(l, GeometricalNumberUtils.getOctogonal(l)));

		
		
		return null;
	}
}
