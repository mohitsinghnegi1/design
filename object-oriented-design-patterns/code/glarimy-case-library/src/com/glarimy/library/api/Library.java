package com.glarimy.library.api;

import java.util.Set;
import java.util.function.Predicate;

public interface Library {
	public Book add(Book book) throws InvalidBookException, LibraryException;

	public Book find(int isbn) throws BookNotFoundException, LibraryException;

	public Set<Book> search(Predicate<Book> condition) throws LibraryException;
}
