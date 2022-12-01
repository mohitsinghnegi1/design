package com.glarimy.broker.domain;

public class Topic {
	private String name;

	public Topic(String name) {
		if (name != null && name.trim().length() >= 3 && name.trim().length() <= 16)
			this.name = name;
		else
			throw new RuntimeException();
	}

	public String getName() {
		return name;
	}

	public boolean equals(Topic other) {
		if (this.name.equalsIgnoreCase(other.getName()))
			return true;
		return false;
	}

}
