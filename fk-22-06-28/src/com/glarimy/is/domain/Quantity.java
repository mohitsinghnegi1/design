package com.glarimy.is.domain;

public class Quantity {
	private String units;
	private int number;

	public Quantity(String units, int number) {
		super();
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
