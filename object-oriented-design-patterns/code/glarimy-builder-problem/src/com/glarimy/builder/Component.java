package com.glarimy.builder;

import java.util.ArrayList;
import java.util.List;

public class Component {
	private List<String> options = new ArrayList<String>();

	public Component(String first, String second, String third) {
		this.options.add(first);
		this.options.add(second);
		this.options.add(third);
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public void service() {
		System.out.println(this.options);
	}

}
