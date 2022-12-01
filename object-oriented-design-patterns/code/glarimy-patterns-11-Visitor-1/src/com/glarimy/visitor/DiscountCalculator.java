package com.glarimy.visitor;

public class DiscountCalculator implements Calculator {
	public double findPriceInRupeesFor(Item item) {
		if (item instanceof DollerItem)
			return ((DollerItem) item).getPrice() * 60 / 10;
		if (item instanceof PoundItem)
			return ((PoundItem) item).getPrice() * 80 / 5;
		return 0;
	}
}
