package com.glarimy.calc.service;

import com.glarimy.calc.api.Calculator;
import com.glarimy.calc.api.CalculatorException;

public class Validator extends Proxy {
	public Validator(Calculator target) {
		super(target);
	}

	@Override
	public void pre(int first, int second) throws CalculatorException {
		if (first < 0 || second < 0)
			throw new CalculatorException("invalid input");
	}
}
