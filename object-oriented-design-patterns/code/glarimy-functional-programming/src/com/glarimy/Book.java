package com.glarimy;

import java.util.function.DoubleFunction;

public class Book {
	private int isbn;
	private String title;
	private double price;

	public double getOfferPriceWithDiscount(double percent) {
		return price * percent;
	}

	public double getOfferPriceWith(DoubleFunction<Double> formula) {
		return formula.apply(price);
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
