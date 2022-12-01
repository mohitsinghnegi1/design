package com.glarimy.library;
import java.util.List;

import com.glarimy.broker.Broker;
import com.glarimy.broker.ConcreteFactory;
import com.glarimy.broker.Message;

public class NotificationProxy implements Library {
	private Library target;
	private Broker broker;

	public NotificationProxy(Library target) {
		this.target = target;
		this.broker = new ConcreteFactory().getBroker();
	}

	@Override
	public Book add(Book book) {
		Book result = target.add(book);
		this.broker.publish(new Message("book-added", book.getTitle()));
		return result;
	}

	@Override
	public Book find(int isbn) {
		Book result = target.find(isbn);
		return result;
	}

	@Override
	public List<Book> search(String title) {
		List<Book> results = target.search(title);
		return results;
	}

}
