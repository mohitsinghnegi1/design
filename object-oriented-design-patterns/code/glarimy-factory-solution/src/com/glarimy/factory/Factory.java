package com.glarimy.factory;

public interface Factory<T> {
	T get(String key) throws Exception;
}