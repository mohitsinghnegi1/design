package com.glarimy.calc.app;

import com.glarimy.calc.api.Calculator;
import com.glarimy.calc.api.Factory;

public class Application {
	public static void main(String[] args) {
		try {
			Calculator calc = Factory.get("calc");
			calc.add(10, 40);
		} catch (Exception e) {
		}
	}

}
