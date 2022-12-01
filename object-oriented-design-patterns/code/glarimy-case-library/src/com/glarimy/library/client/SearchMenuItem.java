package com.glarimy.library.client;

import java.util.Set;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class SearchMenuItem extends AbstractMenuItem {
	public SearchMenuItem(String label, Library library) {
		super(label, library);
	}

	@Override
	public void handle() {
		System.out.print("Search titles containing: ");
		String token = scanner.next();
		try {
			Set<Book> books = library.search(book -> book.getTitle().contains(token));
			System.out.println(books);
		} catch (LibraryException le) {
			System.out.println("Internal error!");
		}
	}
}
