package com.glarimy.os.service;

import com.glarimy.messenger.api.Event;
import com.glarimy.messenger.api.Subscriber;
import com.glarimy.os.api.Cache;

public class CustomerServiceSubscriber implements Subscriber {
	private Cache cache;

	public CustomerServiceSubscriber(Cache cache) {
		this.cache = cache;
	}

	@Override
	public void on(Event<?> event) {
		cache.add((String) event.body);
	}

	@Override
	public String getTopic() {
		return "customer.added";
	}

}
