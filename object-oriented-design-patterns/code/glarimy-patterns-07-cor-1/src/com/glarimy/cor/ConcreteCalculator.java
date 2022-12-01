package com.glarimy.cor;

public class ConcreteCalculator implements Calculator {

	public double compute(double p, double t, double r) throws Exception {
		return p * t * r / 100;
	}

}
