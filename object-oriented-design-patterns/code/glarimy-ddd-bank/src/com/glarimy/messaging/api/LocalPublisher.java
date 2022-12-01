package com.glarimy.messaging.api;

import com.glarimy.messaging.service.SimpleBroker;

public class LocalPublisher implements Publisher {
	@Override
	public void publish(Event event) {
		SimpleBroker.getInstance().notify(event);
	}
}
