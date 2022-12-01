package com.glarimy.library.service;

import java.util.Set;
import java.util.function.Predicate;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundException;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public abstract class AbstractProxy implements Library {
	protected Library target;

	public AbstractProxy(Library target) throws Exception {
		this.target = target;
	}

	@Override
	public Book add(Book book) throws InvalidBookException, LibraryException {
		return target.add(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		return target.find(isbn);
	}

	@Override
	public Set<Book> search(Predicate<Book> condition) throws LibraryException {
		return target.search(condition);
	}

}
