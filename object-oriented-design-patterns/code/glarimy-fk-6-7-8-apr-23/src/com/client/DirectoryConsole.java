package com.client;

import com.broker.api.Broker;
import com.broker.api.Factory;
import com.broker.api.Receiver;
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
		
		Factory factory = new ObjectFactory();

		Broker broker = (Broker) factory.get("broker");
		Receiver receiver = (Receiver) factory.get("receiver");
		broker.register(receiver);

		Directory directory = (Directory) factory.get("directory");
		directory.add(first);
		directory.add(second);
		
		PrintableDirectory printer = new PrintableDirectory(directory);
		printer.print(1);
	}
}
