package com.dir.service;

import java.util.ArrayList;
import java.util.List;

import com.dir.api.domain.Profile;

public class ArrayStorage implements Storage {
	private List<Profile> items;

	public ArrayStorage() {
		items = new ArrayList<>();
	}

	@Override
	public Profile create(Profile profile) {
		items.add(profile);
		return profile;
	}

	@Override
	public Profile read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> read() {
		return items;
	}

}
