package com.glarimy.ui;

import com.glarimy.api.Book;
import com.glarimy.api.BookNotFoundException;
import com.glarimy.api.Library;
import com.glarimy.api.LibraryException;
import com.glarimy.framework.Factory;
import com.glarimy.framework.SimpleFactory;

public class Client {

	public static void main(String[] args) throws Exception {
		Factory factory = new SimpleFactory(true, true);
		Library lib = (Library) factory.get("library");
		try {
			lib.add(new Book(1234, "DDD"));
			Book book = lib.find(1234);
			System.out.println(book);
		} catch (BookNotFoundException e) {
			e.printStackTrace();
		} catch (LibraryException e) {
			e.printStackTrace();
		}
	}

}
