package com.dir.service;

import java.util.List;

import com.dir.api.domain.Profile;

public interface Storage {
	public Profile create(Profile p);
	public Profile read(String id);
	public List<Profile> read();
}
