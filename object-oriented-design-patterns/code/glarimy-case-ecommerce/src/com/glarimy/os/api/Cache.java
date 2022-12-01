package com.glarimy.os.api;

public interface Cache {
	public void add(String e);
	public boolean isFound(String e);
	public void remove(String e);
}
