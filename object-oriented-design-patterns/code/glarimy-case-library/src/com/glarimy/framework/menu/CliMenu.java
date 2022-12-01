package com.glarimy.framework.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CliMenu implements Menu {
	private Map<Integer, MenuItem> items;
	private boolean proceed;

	private CliMenu(List<MenuItem> items) {
		this.items = new HashMap<>();
		for (MenuItem item : items) {
			this.items.put(this.items.size() + 1, item);
		}
		this.items.put(this.items.size() + 1, new MenuItem() {

			@Override
			public void handle() {
				System.out.println("Thanks!");
				proceed = false;
			}

			@Override
			public String getLabel() {
				return "Quit";
			}
		});
	}

	@SuppressWarnings("resource")
	@Override
	public void show() {
		proceed = true;
		while (proceed) {
			for (Integer index : items.keySet()) {
				System.out.println("(" + index + ")" + items.get(index).getLabel());
			}
			System.out.print("Choose: ");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			if (option > items.size())
				System.out.println("Invalid option");
			else
				items.get(option).handle();
		}
	}

	public static class MenuBuilder {
		private List<MenuItem> items;

		public MenuBuilder(MenuItem item) {
			items = new ArrayList<MenuItem>();
			items.add(item);
		}

		public MenuBuilder add(MenuItem item) {
			items.add(item);
			return this;
		}

		public Menu build() {
			return new CliMenu(items);
		}
	}

}
