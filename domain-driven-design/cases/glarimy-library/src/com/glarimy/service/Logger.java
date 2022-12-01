package com.glarimy.service;

import com.glarimy.api.Book;
import com.glarimy.api.BookNotFoundException;
import com.glarimy.api.DuplicateBookException;
import com.glarimy.api.InvalidBookException;
import com.glarimy.api.Library;
import com.glarimy.api.LibraryException;

public class Logger implements Library {
	private Library target;

	public Logger(Library target) {
		super();
		this.target = target;
	}

	@Override
	public Book add(Book book) throws InvalidBookException, DuplicateBookException, LibraryException {
		System.out.println("Entering add method");
		try {
			Book result = target.add(book);
			System.out.println("Leaving add method");
			return result;
		} catch (InvalidBookException ibe) {
			System.out.println("Invalid Book");
			throw ibe;
		} catch (DuplicateBookException dbe) {
			System.out.println("Duplicate");
			throw dbe;
		} catch (LibraryException le) {
			System.out.println("internal");
			throw le;
		}
	}

	@Override
	public Book find(int isbn) throws BookNotFoundException, LibraryException {
		System.out.println("Entering find method");
		try {
			Book result = target.find(isbn);
			System.out.println("Leaving find method");
			return result;
		} catch (BookNotFoundException bne) {
			System.out.println("No Book");
			throw bne;
		} catch (LibraryException le) {
			System.out.println("internal");
			throw le;
		}
	}

}
