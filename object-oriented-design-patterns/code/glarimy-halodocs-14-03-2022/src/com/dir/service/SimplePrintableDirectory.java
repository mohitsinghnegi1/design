package com.dir.service;

import java.util.List;

import com.dir.api.Directory;
import com.dir.api.PrintableDirectory;
import com.dir.api.domain.Profile;
import com.dir.api.exceptions.DirectoryException;
import com.dir.api.exceptions.InvalidProfileException;
import com.dir.api.exceptions.ProfileNotFoundException;

public class SimplePrintableDirectory implements PrintableDirectory {
	private Directory target;

	public SimplePrintableDirectory(Directory target) {
		this.target = target;
	}

	@Override
	public Profile add(Profile profile) throws InvalidProfileException, DirectoryException {
		return target.add(profile);
	}

	@Override
	public Profile find(String id) throws ProfileNotFoundException, DirectoryException {
		return target.find(id);
	}

	@Override
	public List<Profile> list() throws DirectoryException {
		return target.list();
	}

	@Override
	public void print() throws DirectoryException {
		List<Profile> profiles = target.list();
		System.out.println(profiles);
	}

}
