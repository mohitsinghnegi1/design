package com.glarimy.framework.factory;

public interface Factory<T> {
	T get(String key) throws Exception;
}