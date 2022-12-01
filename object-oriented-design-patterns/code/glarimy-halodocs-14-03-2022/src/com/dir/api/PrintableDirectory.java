package com.dir.api;

import com.dir.api.exceptions.DirectoryException;

public interface PrintableDirectory extends Directory {
	public void print() throws DirectoryException;
}
