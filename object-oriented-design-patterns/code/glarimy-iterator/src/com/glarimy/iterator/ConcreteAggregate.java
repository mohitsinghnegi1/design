package com.glarimy.iterator;

public class ConcreteAggregate<T> implements Aggregate<T> {
	private Object[] elements;
	private int index = 0;
	private int size;

	public ConcreteAggregate(int size) {
		this.size = size;
		elements = new Object[size];
	}

	@Override
	public void add(T element) throws RuntimeException {
		if (index == this.size)
			throw new RuntimeException("Out of bounds");

		elements[index++] = element;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<T> getIterator() {
		return new ConcreteIterator<T>((T[])elements);
	}

}
