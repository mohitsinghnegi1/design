package com.glarimy.library.client;

import com.glarimy.framework.factory.Factory;
import com.glarimy.framework.factory.SimpleFactory;
import com.glarimy.framework.menu.CliMenu;
import com.glarimy.framework.menu.Menu;
import com.glarimy.framework.menu.MenuItem;
import com.glarimy.library.api.Library;

public class LibraryConsole {
	public static void main(String[] args) throws Exception {
		Factory<Library> factory = new SimpleFactory<Library>();
		Library library = factory.get("library");
		MenuItem add = new AddMenuItem("Add Book", library);
		MenuItem find = new FindMenuItem("Find Book", library);
		MenuItem search = new SearchMenuItem("Search Books by Title", library);
		MenuItem searchByPrefix = new SearchByPrefixMenuItem("Search Books by Prefix", library);
		MenuItem searchBySuffix = new SearchBySuffixMenuItem("Search Books by Suffix", library);
		Menu menu = new CliMenu.MenuBuilder(add).add(find).add(search).add(searchByPrefix).add(searchBySuffix).build();
		menu.show();
	}
}
