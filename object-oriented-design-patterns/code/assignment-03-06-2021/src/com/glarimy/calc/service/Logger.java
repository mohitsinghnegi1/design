package com.glarimy.calc.service;

import java.util.Date;

import com.glarimy.calc.api.Calculator;
import com.glarimy.calc.api.CalculatorException;

public class Logger extends Proxy {

	public Logger(Calculator target) {
		super(target);
	}

	@Override
	public void pre(int first, int second) throws CalculatorException {
		System.out.println("Logger: " + new Date() + "- Adding " + first + " and " + second);
	}

	@Override
	public void post(long sum) throws CalculatorException {
		System.out.println("Logger: " + new Date() + "- Returning " + sum);

	}

	@Override
	public void handle(CalculatorException e) throws CalculatorException {
		System.out.println("Logger: " + new Date() + "- Received " + e.getMessage());
	}
}
