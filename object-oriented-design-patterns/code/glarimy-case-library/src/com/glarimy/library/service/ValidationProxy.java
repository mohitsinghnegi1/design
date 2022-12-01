package com.glarimy.library.service;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class ValidationProxy extends AbstractProxy {
	public ValidationProxy(Library target) throws Exception {
		super(target);
	}

	@Override
	public Book add(Book book) throws InvalidBookException, LibraryException {
		if (book == null || book.getIsbn() < 1 || book.getTitle() == null || book.getTitle().trim().length() == 0)
			throw new InvalidBookException();
		return target.add(book);
	}
}
