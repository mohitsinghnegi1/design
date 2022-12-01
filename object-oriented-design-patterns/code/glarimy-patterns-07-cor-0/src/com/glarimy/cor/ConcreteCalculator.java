package com.glarimy.cor;

public class ConcreteCalculator implements Calculator {

	public double compute(double p, double t, double r) throws Exception {
		System.out.println("Entering compute()");
		if (p < 0 || t < 0 || r < 0) {
			System.out.println("Exiting compute()");
			throw new Exception("Invalid input");
		}
		double interest = p * t * r / 100;
		System.out.println("Leaving compute()");
		return interest;
	}

}
