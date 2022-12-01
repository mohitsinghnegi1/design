package com.glarimy.directory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.EmployeeDirectory;
import com.glarimy.directory.api.EmployeeNotFoundException;
import com.glarimy.directory.api.InvalidEmployeeException;
import com.glarimy.directory.data.Storage;
import com.glarimy.framework.ConstructWith;

@ConstructWith(param="storage")
public class EmployeeDirectoryService implements EmployeeDirectory {
	private Storage storage;

	public EmployeeDirectoryService(Storage storage) {
		this.storage = storage;
	}

	@Override
	public Employee add(Employee e) throws InvalidEmployeeException, DirectoryException {
		try {
			return storage.create(e);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DirectoryException();
		}
	}

	@Override
	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException {
		try {
			Employee e = storage.read(id);
			if (e == null)
				throw new EmployeeNotFoundException();
			return e;
		} catch (Exception e) {
			throw new DirectoryException();
		}
	}

	@Override
	public List<Employee> search(Predicate<Employee> c) throws DirectoryException {
		List<Employee> results = new ArrayList<Employee>();
		for (Employee e : this.storage.list()) {
			if (c.test(e) == true) {
				results.add(e);
			}
		}
		return results;
	}

}
