package com.dir.api;

import java.util.List;

import com.dir.api.domain.Profile;
import com.dir.api.exceptions.DirectoryException;
import com.dir.api.exceptions.InvalidProfileException;
import com.dir.api.exceptions.ProfileNotFoundException;

public interface Directory {
	public Profile add(Profile profile) throws InvalidProfileException, DirectoryException;

	public Profile find(String id) throws ProfileNotFoundException, DirectoryException;

	public List<Profile> list() throws DirectoryException;
}
