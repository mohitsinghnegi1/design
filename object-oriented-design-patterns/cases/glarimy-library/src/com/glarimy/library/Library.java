package com.glarimy.library;

import java.util.List;

public interface Library {
	public Book add(Book book);

	public Book find(int isbn);

	public List<Book> search(String title);
}
