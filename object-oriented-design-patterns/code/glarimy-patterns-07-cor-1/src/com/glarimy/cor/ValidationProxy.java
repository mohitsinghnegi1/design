package com.glarimy.cor;

public class ValidationProxy implements Calculator {
	private Calculator target;

	public ValidationProxy(Calculator target) {
		this.target = target;
	}

	public double compute(double p, double t, double r) throws Exception {
		if (p < 0 || t < 0 || r < 0)
			throw new Exception("Invalid input");
		return this.target.compute(p, t, r);
	}

}
