package com.glarimy.visitor;

public abstract class Item {
	public double accept(Calculator calculator) {
		return calculator.findPriceInRupeesFor(this);
	}
}
