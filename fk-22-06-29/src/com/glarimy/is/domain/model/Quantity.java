package com.glarimy.is.domain.model;

import com.glarimy.is.domain.service.InvalidProductException;

public class Quantity {
	private String units;
	private int number;

	public Quantity(String units, int number) {
		if (number < 0 || units == null || units.trim().length() == 0)
			throw new InvalidProductException();
		this.units = units;
		this.number = number;
	}

	public String getUnits() {
		return units;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Quantity [units=" + units + ", number=" + number + "]";
	}

}
