package com.glarimy.calc.service;

import com.glarimy.calc.api.Calculator;
import com.glarimy.calc.api.CalculatorException;

public abstract class Proxy implements Calculator {
	private Calculator target;

	public Proxy(Calculator target) {
		this.target = target;
	}

	public void pre(int first, int second) throws CalculatorException {

	}

	public void post(long sum) throws CalculatorException {

	}

	public void handle(CalculatorException e) throws CalculatorException {

	}

	@Override
	public long add(int first, int second) throws CalculatorException {
		try {
			pre(first, second);
			long result = target.add(first, second);
			post(result);
			return result;
		} catch (CalculatorException ce) {
			handle(ce);
			throw ce;
		}
	}

}
