package com.glarimy.builder;

import java.util.ArrayList;
import java.util.List;

public class Component {
	private List<String> options = new ArrayList<String>();

	private Component(String first, String second, String third) {
		this.options.add(first);
		this.options.add(second);
		this.options.add(third);
	}

	public String[] getOptions() {
		return (String[]) options.toArray();
	}

	public void service() {
		System.out.println(this.options);
	}
	
	public static class ComponentBuilder{
		private List<String> options = new ArrayList<String>();
		
		public ComponentBuilder add(String option) {
			options.add(option);
			return this;
		}
		
		public Component build() {
			return new Component(options.get(0), options.get(1), options.get(2));
		}
	}

}
