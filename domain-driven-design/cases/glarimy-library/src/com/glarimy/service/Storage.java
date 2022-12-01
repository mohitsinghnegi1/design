package com.glarimy.service;

import com.glarimy.api.Book;

public interface Storage {
	public Book save(Book book);
	public Book fetch(int isbn);
}
