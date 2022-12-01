package com.client;

import com.broker.api.Broker;
import com.broker.api.Handler;
import com.dir.api.Directory;
import com.dir.api.model.User;

public class DirectoryConsole {
	public static void main(String[] args) throws Exception {
		User first = new User();
		first.setName("Krishna Mohan Koyya");
		first.setPhone(9731423166L);

		User second = new User();
		second.setName("Vishnu Teja Koyya");
		second.setPhone(9731423166L);

		Broker broker = (Broker) ObjectFactory.get("broker");
		Handler handler = (Handler) ObjectFactory.get("handler");
		broker.subscribe(handler);

		Directory directory = (Directory) ObjectFactory.get("directory");
		directory.add(first);
		directory.add(second);
		
		PrintableDirectory printer = new PrintableDirectory(directory);
		printer.print(1);
	}
}
