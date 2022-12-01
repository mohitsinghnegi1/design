package com.glarimy.os.service;

import java.util.ArrayList;
import java.util.List;

import com.glarimy.commons.api.Singleton;
import com.glarimy.os.api.Cache;

@Singleton
public class CacheImpl implements Cache {
	public List<String> entries;

	private static CacheImpl INSTANCE = null;

	private CacheImpl() {
		entries = new ArrayList<String>();
	}

	public synchronized static CacheImpl getInstance() {
		if (INSTANCE == null)
			INSTANCE = new CacheImpl();
		return INSTANCE;
	}

	@Override
	public void add(String e) {
		System.out.println("Cached " + e);
		entries.add(e);
	}

	@Override
	public boolean isFound(String e) {
		return entries.contains(e);
	}

	@Override
	public void remove(String e) {
		entries.remove(e);
	}

}
