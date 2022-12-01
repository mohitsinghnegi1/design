package com.glarimy.infra;

public interface Factory {

	public Object get(String key) throws Exception;
}
