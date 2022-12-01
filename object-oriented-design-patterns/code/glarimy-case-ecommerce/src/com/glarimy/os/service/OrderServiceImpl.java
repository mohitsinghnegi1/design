package com.glarimy.os.service;

import com.glarimy.commons.api.Factory;
import com.glarimy.messenger.api.Messenger;
import com.glarimy.os.api.Cache;
import com.glarimy.os.api.OrderService;

public class OrderServiceImpl implements OrderService {
	public OrderServiceImpl() throws Exception {
		@SuppressWarnings("rawtypes")
		Factory factory = new Factory<Messenger>("config.properties");
		Messenger messenger = (Messenger) factory.get("messenger");
		Cache cache = (Cache) factory.get("cache");
		messenger.add(new CustomerServiceSubscriber(cache));
	}
}
