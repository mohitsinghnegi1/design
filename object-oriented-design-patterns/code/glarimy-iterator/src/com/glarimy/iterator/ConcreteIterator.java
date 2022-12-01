package com.glarimy.iterator;

public class ConcreteIterator<T> implements Iterator<T> {
	private T[] snapshot;
	private int index;

	public ConcreteIterator(T[] snapshot) {
		this.snapshot = snapshot;
		this.index = -1;
	}

	@Override
	public boolean hasNext() {
		if(snapshot.length > 0 && index < snapshot.length)
			return true;
		return false;
	}

	@Override
	public T next() throws RuntimeException {
		if(snapshot.length > 0 && index < snapshot.length)
			return snapshot[++index];
		throw new RuntimeException();
	}

	@Override
	public T previous() throws RuntimeException {
		if(snapshot.length > 0 && index > 0 )
			return snapshot[--index];
		throw new RuntimeException();
	}

	@Override
	public T first() throws RuntimeException {
		if(snapshot.length> 0)
			return snapshot[0];
		throw new RuntimeException();
	}

	@Override
	public T last() throws RuntimeException {
		if(snapshot.length > 0 )
			return snapshot[snapshot.length-1];
		throw new RuntimeException();
	}

}
