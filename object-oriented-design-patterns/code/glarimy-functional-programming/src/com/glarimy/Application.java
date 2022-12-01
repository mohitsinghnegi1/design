package com.glarimy;

public class Application {
	public static void main(String[] args) {
		Book book = new Book();
		book.setIsbn(1234);
		book.setTitle("Good Book");
		book.setPrice(100);

		double offer = book.getOfferPriceWith(price -> price / 10);

		System.out.println(offer);

	}
}
