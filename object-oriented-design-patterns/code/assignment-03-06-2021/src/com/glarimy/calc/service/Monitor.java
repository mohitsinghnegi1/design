package com.glarimy.calc.service;

import java.util.Date;

import com.glarimy.calc.api.Calculator;
import com.glarimy.calc.api.CalculatorException;

public class Monitor extends Proxy {
	private long start;

	public Monitor(Calculator target) {
		super(target);
	}

	@Override
	public void pre(int first, int second) throws CalculatorException {
		start = new Date().getTime();
	}

	@Override
	public void post(long sum) throws CalculatorException {
		long end = new Date().getTime();
		System.out.println("Monitor: Finished in " + (end-start) + " milli seconds");

	}

	@Override
	public void handle(CalculatorException e) throws CalculatorException {
		long end = new Date().getTime();
		System.out.println("Monitor: Finished in " + (end-start) + " milli seconds");
	}
}
