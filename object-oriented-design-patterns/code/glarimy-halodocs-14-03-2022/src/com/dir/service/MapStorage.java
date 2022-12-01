package com.dir.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dir.api.domain.Profile;

public class MapStorage implements Storage{
	private Map<String, Profile> profiles;


	public MapStorage() {
		this.profiles = new HashMap<>();
	}

	@Override
	public Profile create(Profile profile) {
		profile.setId(profile.getName());
		profiles.put(profile.getName(), profile);
		return profile;
	}

	@Override
	public Profile read(String id) {
		return profiles.get(id);
	}

	@Override
	public List<Profile> read() {
		return new ArrayList<Profile>(profiles.values());
	}

}
