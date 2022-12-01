package com.glarimy.service;

import com.glarimy.api.Book;
import com.glarimy.api.BookNotFoundException;
import com.glarimy.api.DuplicateBookException;
import com.glarimy.api.InvalidBookException;
import com.glarimy.api.Library;
import com.glarimy.api.LibraryException;

public class Validator implements Library {
	private Library target;

	public Validator(Library target) {
		this.target = target;
	}

	@Override
	public Book add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		if (book == null)
			throw new InvalidBookException();
		Book result = target.add(book);
		return result;
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		Book result = target.find(isbn);
		return result;
	}

}
