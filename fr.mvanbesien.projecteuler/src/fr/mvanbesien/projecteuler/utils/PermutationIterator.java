package fr.mvanbesien.projecteuler.utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PermutationIterator<T> implements Iterator<T[]> {

	private final Map<Integer, T> elements;

	private final int bagsize;

	private BigInteger index;

	private BigInteger maxIndex;

	public PermutationIterator(T[] elements, int bagsize) {
		this.elements = new HashMap<>();
		for (int i = 0; i < elements.length; i++)
			this.elements.put(i, elements[i]);
		this.bagsize = bagsize;
		this.index = BigInteger.ZERO;
		this.maxIndex = arrangement(elements.length, bagsize);
	}

	private BigInteger arrangement(int elementNumber, int bagsize) {
		return this.fact(elementNumber).divide(this.fact(elementNumber - bagsize));
	}

	private BigInteger fact(int value) {
		BigInteger fact = BigInteger.ONE;
		for (int i = 2; i < value; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

	@Override
	public boolean hasNext() {
		return this.index.compareTo(this.maxIndex) <= 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] next() {
		BigInteger workingIndex = this.index;
		List<Integer> workingCopy = new ArrayList<>(this.elements.keySet());
		Object[] solution = new Object[this.bagsize];
		for (int i = 0; i < this.bagsize; i++) {
			int index = workingIndex.mod(BigInteger.valueOf(workingCopy.size())).intValue();
			solution[i] = this.elements.get(workingCopy.get(index));
			workingIndex = workingIndex.divide(BigInteger.valueOf(workingCopy.size()));
			workingCopy.remove(index);
		}
		this.index = this.index.add(BigInteger.ONE);
		return (T[]) solution;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
