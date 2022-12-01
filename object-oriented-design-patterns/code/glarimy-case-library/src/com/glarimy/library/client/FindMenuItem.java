package com.glarimy.library.client;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.BookNotFoundException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class FindMenuItem extends AbstractMenuItem {
	public FindMenuItem(String label, Library library) {
		super(label, library);
	}

	@Override
	public void handle() {
		System.out.print("Enter ISBN: ");
		int isbn = scanner.nextInt();
		try {
			Book book = library.find(isbn);
			System.out.println(book);
		} catch (BookNotFoundException bne) {
			System.out.println("No book found!");
		} catch (LibraryException le) {
			System.out.println("Internal error!");
		}
	}
}
