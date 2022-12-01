package com.glarimy.iterator;

public interface Aggregate<T> {
	public void add(T element) throws RuntimeException;
	public Iterator<T> getIterator();
}
