package com.glarimy.app;

import java.util.Scanner;

import com.glarimy.menu.CliMenu;
import com.glarimy.menu.Menu;
import com.glarimy.menu.MenuItem;

public class Calculator {
	public static void main(String[] args) {
		Menu menu = new CliMenu.MenuBuilder(new MenuItem() {

			@Override
			public void handle() {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter a number: ");
				int number = scanner.nextInt();
				System.out.println(number * number);
			}

			@Override
			public String getLabel() {
				return "Find square";
			}
		}).add(new MenuItem() {

			@Override
			public void handle() {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter a number: ");
				int number = scanner.nextInt();
				System.out.println(number * number * number);
			}

			@Override
			public String getLabel() {
				return "Find cube";
			}
		}).build();

		menu.show();
	}
}
