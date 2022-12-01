package com.glarimy.library.client;

import java.util.Scanner;

import com.glarimy.framework.menu.MenuItem;
import com.glarimy.library.api.Library;

public abstract class AbstractMenuItem implements MenuItem {
	protected String label;
	protected Library library;
	protected Scanner scanner;

	public AbstractMenuItem(String label, Library library) {
		this.label = label;
		this.library = library;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public String getLabel() {
		return label;
	}
}
