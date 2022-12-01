package com.glarimy.library.service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import com.glarimy.framework.factory.Factory;
import com.glarimy.framework.factory.SimpleFactory;
import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundException;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class SimpleLibrary implements Library {
	private Storage storage;

	public SimpleLibrary() throws Exception {
		Factory<Storage> factory = new SimpleFactory<Storage>();
		storage = factory.get("storage");
	}

	@Override
	public Book add(Book book) throws InvalidBookException, LibraryException {
		return storage.save(book);
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		Book book = storage.find(isbn);
		if (book == null)
			throw new BookNotFoundException();
		return book;
	}

	@Override
	public Set<Book> search(Predicate<Book> condition) throws LibraryException {
		Set<Book> books = new HashSet<Book>();
		storage.list().stream().filter(condition).forEach(book -> books.add(book));
		return books;
	}

}
