package com.glarimy.cor;

public class Application {
	public static void main(String[] args) throws Exception {
		Calculator calc = Factory.get(true, true);
		System.out.println(calc.compute(1000, 4, -6));
	}
}