package com.glarimy.app;

import com.glarimy.menu.CliMenu;
import com.glarimy.menu.Menu;
import com.glarimy.menu.MenuItem;

public class Application {
	public static void main(String[] args) {
		CliMenu.MenuBuilder builder = new CliMenu.MenuBuilder(new MenuItem() {

			@Override
			public void handle() {
				System.out.println("New Delhi");
			}

			@Override
			public String getLabel() {
				return "India";
			}
		});

		builder.add(new MenuItem() {

			@Override
			public void handle() {
				System.out.println("Khatmandu");
			}

			@Override
			public String getLabel() {
				return "Nepal";
			}
		});

		builder.add(new MenuItem() {

			@Override
			public void handle() {
				System.out.println("Islamabad");
			}

			@Override
			public String getLabel() {
				return "Pakistan";
			}
		});

		Menu menu = builder.build();

		menu.show();
	}
}
