package com.glarimy.is.app;

import java.util.Map;

public interface Factory {
	public Object get(Map<String, String> config);
}
