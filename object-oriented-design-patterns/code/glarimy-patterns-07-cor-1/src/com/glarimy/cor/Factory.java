package com.glarimy.cor;

public class Factory {
	public static  Calculator get(boolean logging, boolean validation) {
		Calculator calc = new ConcreteCalculator();
		if (validation)
			calc = new ValidationProxy(calc);
		if (logging)
			calc = new LoggingProxy(calc);
		return calc;
	}
}
