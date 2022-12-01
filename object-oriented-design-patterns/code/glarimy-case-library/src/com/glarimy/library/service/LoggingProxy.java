package com.glarimy.library.service;

import java.util.Date;
import java.util.Set;
import java.util.function.Predicate;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundException;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class LoggingProxy extends AbstractProxy {
	public LoggingProxy(Library target) throws Exception {
		super(target);
	}

	@Override
	public Book add(Book book) throws InvalidBookException, LibraryException {
		System.out.println(new Date() + ": Entering addBook()");
		book = target.add(book);
		System.out.println(new Date() + ": Leaving addBook()");
		return book;
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		System.out.println(new Date() + ": Entering find()");
		Book book = target.find(isbn);
		System.out.println(new Date() + ": Leaving find()");
		return book;
	}

	@Override
	public Set<Book> search(Predicate<Book> condition) throws LibraryException {
		System.out.println(new Date() + ": Entering search()");
		Set<Book> books = target.search(condition);
		System.out.println(new Date() + ": Leaving search()");
		return books;
	}

}
