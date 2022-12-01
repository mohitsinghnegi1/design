package com.glarimy.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.api.Book;

public class InMemoryStorage implements Storage {
	private Map<Integer, Book> entries;

	public InMemoryStorage() {
		entries = new HashMap<Integer, Book>();
	}

	@Override
	public Book fetch(int isbn) {
		return entries.get(isbn);
	}

	@Override
	public Book save(Book book) {
		entries.put(book.getIsbn(), book);
		return book;
	}
}
