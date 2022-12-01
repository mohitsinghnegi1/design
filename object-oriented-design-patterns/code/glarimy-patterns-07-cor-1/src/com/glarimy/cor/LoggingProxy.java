package com.glarimy.cor;

public class LoggingProxy implements Calculator {
	private Calculator target;

	public LoggingProxy(Calculator target) {
		this.target = target;
	}

	public double compute(double p, double t, double r) throws Exception {
		System.out.println("Entering compute()");
		try {
			double interest = this.target.compute(p, t, r);
			System.out.println("Leaving compute()");
			return interest;
		} catch (Exception e) {
			System.out.println("Exiting compute()");
			throw e;
		}
	}
}
