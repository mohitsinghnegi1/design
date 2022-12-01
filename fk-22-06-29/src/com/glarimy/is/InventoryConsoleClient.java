package com.glarimy.is;

import com.glarimy.is.app.InventoryController;
import com.glarimy.is.app.Item;

public class InventoryConsoleClient {

	public static void main(String[] args) {
		try {
			InventoryController ic = new InventoryController();
			Item p = new Item();
			p.id = 1;
			p.available = 10;
			p.units = "items";
			ic.add(p);
			ic.reserve(1, 5, "items");
			ic.consume(1, 5, "items");
			System.out.println(ic.find(1));
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
