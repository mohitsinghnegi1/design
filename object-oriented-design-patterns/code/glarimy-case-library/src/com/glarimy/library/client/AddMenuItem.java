package com.glarimy.library.client;

import com.glarimy.library.api.Book;
import com.glarimy.library.api.InvalidBookException;
import com.glarimy.library.api.Library;
import com.glarimy.library.api.LibraryException;

public class AddMenuItem extends AbstractMenuItem {
	public AddMenuItem(String label, Library library) {
		super(label, library);
	}

	@Override
	public void handle() {
		System.out.print("Enter ISBN: ");
		int isbn = scanner.nextInt();
		System.out.print("Enter Title: ");
		String title = scanner.next();
		Book book = new Book(isbn, title);
		try {
			library.add(book);
		} catch (InvalidBookException ibe) {
			System.out.println("Invalid data!");
		} catch (LibraryException le) {
			System.out.println("Internal error!");
		}
	}
}
