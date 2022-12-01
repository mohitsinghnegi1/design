package com.glarimy.calc.service;

import com.glarimy.calc.api.Calculator;
import com.glarimy.calc.api.CalculatorException;

public class SimpleCalculator implements Calculator {
	@Override
	public long add(int first, int second) throws CalculatorException {
		return first + second;
	}
}
