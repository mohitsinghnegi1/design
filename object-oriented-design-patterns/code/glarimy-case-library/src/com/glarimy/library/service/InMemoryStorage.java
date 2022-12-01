package com.glarimy.library.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.glarimy.library.api.Book;

public class InMemoryStorage implements Storage {
	private static InMemoryStorage INSTANCE = null;
	private Map<Integer, Book> books;

	private InMemoryStorage() {
		books = new HashMap<Integer, Book>();
	}

	public synchronized static InMemoryStorage getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryStorage();
		return INSTANCE;
	}

	@Override
	public Book find(int id) {
		return books.get(id);
	}

	@Override
	public Collection<Book> list() {
		return books.values();
	}

	@Override
	public Book save(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}
}
