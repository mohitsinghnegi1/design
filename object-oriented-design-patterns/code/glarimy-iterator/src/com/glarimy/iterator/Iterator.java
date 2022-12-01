package com.glarimy.iterator;

public interface Iterator<T> {
	public boolean hasNext();
	public T next() throws RuntimeException;
	public T previous() throws RuntimeException;
	public T first() throws RuntimeException;
	public T last() throws RuntimeException;
}
