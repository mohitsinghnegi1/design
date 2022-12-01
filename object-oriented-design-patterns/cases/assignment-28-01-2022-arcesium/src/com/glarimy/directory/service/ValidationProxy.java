package com.glarimy.directory.service;

import java.util.List;
import java.util.function.Predicate;

import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.EmployeeDirectory;
import com.glarimy.directory.api.EmployeeNotFoundException;
import com.glarimy.directory.api.InvalidEmployeeException;

public class ValidationProxy implements EmployeeDirectory {
	private EmployeeDirectory target;

	public ValidationProxy(EmployeeDirectory target) {
		this.target = target;
	}

	@Override
	public Employee add(Employee e) throws InvalidEmployeeException, DirectoryException {
		if (e == null || e.getName() == null || e.getName().trim().length() == 0 || e.getPhoneNumber() < 1)
			throw new InvalidEmployeeException();
		return this.target.add(e);
	}

	@Override
	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException {
		return this.target.find(id);
	}

	@Override
	public List<Employee> search(Predicate<Employee> c) throws DirectoryException {
		return this.target.search(c);
	}

}
