package com.glarimy.api;

public class Book {
	private int isbn;
	private String title;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int isbn, String title) {
		super();
		this.isbn = isbn;
		this.title = title;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + "]";
	}
	
	
}
