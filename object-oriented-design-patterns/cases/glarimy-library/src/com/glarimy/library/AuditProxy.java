package com.glarimy.library;

import java.util.List;

public class AuditProxy implements Library {
	private Library target;

	public AuditProxy(Library target) {
		this.target = target;
	}

	@Override
	public Book add(Book book) {
		Book result = target.add(book);
		System.out.println("Audit: added book");
		return result;
	}

	@Override
	public Book find(int isbn) {
		Book result = target.find(isbn);
		System.out.println("Audit: searched for book by isbn");
		return result;
	}

	@Override
	public List<Book> search(String title) {
		List<Book> results = target.search(title);
		System.out.println("Audit: searched for books by title");
		return results;
	}

}
