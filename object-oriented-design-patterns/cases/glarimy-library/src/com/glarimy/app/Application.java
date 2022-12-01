package com.glarimy.app;

import com.glarimy.broker.Broker;
import com.glarimy.broker.ConcreteFactory;
import com.glarimy.broker.Handler;
import com.glarimy.broker.Message;
import com.glarimy.library.Book;
import com.glarimy.library.Library;
import com.glarimy.library.LibraryBuilder;

public class Application {
	public static void main(String[] args) {
		Broker broker = new ConcreteFactory().getBroker();
		broker.subscribe("book-added", new Handler() {

			@Override
			public void handle(Message message) {
				System.out.println("Handler: " + message.getBody());
			}
		});

		Library library = new LibraryBuilder().withNotifications().build();
		library.add(new Book(123, "GoF", 425));
	}
}
