package com.dir.service;

import java.util.List;

import com.dir.api.Directory;
import com.dir.api.domain.Profile;
import com.dir.api.exceptions.DirectoryException;
import com.dir.api.exceptions.InvalidProfileException;
import com.dir.api.exceptions.ProfileNotFoundException;

public class SimpleDirectory implements Directory {
	private Storage storage;
	private Security security;
	private Broker broker;

	public void setSecurity(Security security) {
		this.security = security;
	}

	public void setBroker(Broker broker) {
		this.broker = broker;
	}

	private SimpleDirectory() {

	}

	void setStorage(Storage storage) {
		this.storage = storage;
	}

	@Override
	public Profile add(Profile profile) throws InvalidProfileException, DirectoryException {
		if (profile == null || profile.getName() == null || profile.getName().length() < 8)
			throw new InvalidProfileException();
		return storage.create(profile);
	}

	@Override
	public Profile find(String id) throws ProfileNotFoundException, DirectoryException {
		Profile profile = storage.read(id);
		if (profile == null)
			throw new ProfileNotFoundException();
		return profile;
	}

	@Override
	public List<Profile> list() throws DirectoryException {
		return storage.read();
	}

	public static class Builder {
		private Security security;
		private Broker broker;

		public Builder withSecurity() {
			security = new Security();
			return this;
		}

		public Builder withBroker() {
			broker = new Broker();
			return this;
		}

		public SimpleDirectory withStorage(Storage storage) {
			SimpleDirectory dir = new SimpleDirectory();
			dir.setStorage(storage);
			if (security != null)
				dir.setSecurity(security);
			if (broker != null)
				dir.setBroker(broker);
			return dir;
		}
	}

}
