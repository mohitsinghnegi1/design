package com.glarimy.visitor;

import java.util.ArrayList;
import java.util.List;

public class Application {
	public static void main(String[] args) throws Exception {
		DiscountCalculator calc = new DiscountCalculator();
		List<Item> items = new ArrayList<>();
		items.add(new PoundItem(100));
		items.add(new PoundItem(500));
		items.add(new PoundItem(110));
		items.add(new DollerItem(250));
		items.add(new PoundItem(80));
		double total = 0;
		for (Item item : items)
			total += item.accept(calc);
		System.out.println("Total : Rs." + total);
	}
}