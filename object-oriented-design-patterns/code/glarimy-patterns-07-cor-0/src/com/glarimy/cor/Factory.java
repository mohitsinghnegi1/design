package com.glarimy.cor;

public class Factory {
	public static Calculator get() {
		Calculator calc = new ConcreteCalculator();
		return calc;
	}
}
