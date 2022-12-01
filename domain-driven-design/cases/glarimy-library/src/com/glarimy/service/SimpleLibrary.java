package com.glarimy.service;

import com.glarimy.api.Book;
import com.glarimy.api.BookNotFoundException;
import com.glarimy.api.DuplicateBookException;
import com.glarimy.api.InvalidBookException;
import com.glarimy.api.Library;
import com.glarimy.api.LibraryException;

public class SimpleLibrary implements Library {
	private Storage storage;

	public SimpleLibrary(Storage storage) {
		this.storage = storage;
	}

	@Override
	public Book add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		if (storage.fetch(book.getIsbn()) != null)
			throw new DuplicateBookException();
		storage.save(book);
		return book;
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		Book book = storage.fetch(isbn);
		if (book == null)
			throw new BookNotFoundException();
		return book;
	}

}
