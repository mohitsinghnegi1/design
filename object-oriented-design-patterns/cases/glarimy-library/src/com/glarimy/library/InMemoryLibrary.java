package com.glarimy.library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryLibrary implements Library {
	private static InMemoryLibrary INSTANCE;
	private Map<Integer, Book> books;

	protected static InMemoryLibrary getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryLibrary();
		return INSTANCE;
	}

	private InMemoryLibrary() {
		books = new HashMap<Integer, Book>();
	}

	@Override
	public Book add(Book book) {
		books.put(book.getIsbn(), book);
		return book;
	}

	@Override
	public Book find(int isbn) {
		return books.get(isbn);
	}

	@Override
	public List<Book> search(String title) {
		return books.values().stream().filter(b -> b.getTitle().contains(title)).collect(Collectors.toList());
	}

}
