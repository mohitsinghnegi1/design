package com.glarimy.directory.service;

import java.util.List;
import java.util.function.Predicate;

import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.EmployeeDirectory;
import com.glarimy.directory.api.EmployeeNotFoundException;
import com.glarimy.directory.api.InvalidEmployeeException;

public class LoggingProxy implements EmployeeDirectory {
	private EmployeeDirectory target;

	public LoggingProxy(EmployeeDirectory target) {
		this.target = target;
	}

	@Override
	public Employee add(Employee e) throws InvalidEmployeeException, DirectoryException {
		System.out.println("Adding an employee: " + e);
		try {
			Employee emp = this.target.add(e);
			System.out.println("Added employee: " + emp);
			return emp;
		} catch (InvalidEmployeeException iee) {
			System.out.println("Error:" + iee.getMessage());
			throw iee;
		} catch (DirectoryException de) {
			System.out.println("Error: " + de.getMessage());
			throw de;
		}
	}

	@Override
	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException {
		System.out.println("Finding employee with id: " + id);
		Employee e = this.target.find(id);
		System.out.println("Found employee: " + e);
		return e;
	}

	@Override
	public List<Employee> search(Predicate<Employee> c) throws DirectoryException {
		return this.target.search(c);
	}

}
