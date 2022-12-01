package com.glarimy.library.service;

import java.util.Collection;

import com.glarimy.library.api.Book;

public interface Storage {
	public Book save(Book book);

	public Book find(int id);

	public Collection<Book> list();
}
