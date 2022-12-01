package com.glarimy.composit;

import java.util.ArrayList;
import java.util.List;

public abstract class Container implements Component {
	private List<Component> parts = new ArrayList<>();
	
	public void add(Component part) {
		parts.add(part);
	}
	
	public void remove(Component part) {
		parts.remove(part);
	}
	
	public void service() {
		for(Component part: parts)
			part.service();
	}
}
