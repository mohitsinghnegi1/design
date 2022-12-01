package com.glarimy.is.domain.service;

import java.util.Date;

import com.glarimy.is.domain.model.Product;
import com.glarimy.is.domain.model.Quantity;

public class Logger implements InventoryService {
	private InventoryService target;

	public Logger(InventoryService target) {
		this.target = target;
	}

	@Override
	public Product add(Product p) {
		System.out.println(new Date() + " Adding: " + p);
		Product ret = target.add(p);
		System.out.println(new Date() + " Added: " + ret);
		return ret;
	}

	@Override
	public Product remove(int id) {
		System.out.println(new Date() + " Removing: " + id);
		Product ret = target.remove(id);
		System.out.println(new Date() + " Removed: " + ret);
		return ret;
	}

	@Override
	public Product replenish(int id, Quantity quantity) {
		System.out.println(new Date() + " Replenishing: " + id);
		Product ret = target.replenish(id, quantity);
		System.out.println(new Date() + " Replenished: " + ret);
		return ret;

	}

	@Override
	public Product reserve(int id, Quantity quantity) {
		System.out.println(new Date() + " Reserving: " + id);
		Product ret = target.reserve(id, quantity);
		System.out.println(new Date() + " Reserved: " + ret);
		return ret;
	}

	@Override
	public Product consume(int id, Quantity quantity) {
		System.out.println(new Date() + " Consuming: " + id);
		Product ret = target.consume(id, quantity);
		System.out.println(new Date() + " Consumed: " + ret);
		return ret;
	}

	@Override
	public Product fetch(int id) {
		System.out.println(new Date() + " Fetchging: " + id);
		Product ret = target.fetch(id);
		System.out.println(new Date() + " Fetched: " + ret);
		return ret;

	}

}
