package com.glarimy.dir.service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.domain.Employee;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.EmployeeNotFoundException;
import com.glarimy.dir.api.exceptions.InvalidEmployeeException;

public class DirectoryLogger implements Directory {
	private Directory target;

	public DirectoryLogger(Directory target) {
		this.target = target;
	}

	@Override
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException {
		try {
			System.out.println(new Date() + ": [DirectoryLogger] entering add employee");
			int result = target.add(employee);
			System.out.println(new Date() + ": [DirectoryLogger] leaving add employee");
			return result;
		} catch (DirectoryException e) {
			System.out.println(new Date() + ": [DirectoryLogger] received " + e.getMessage());
			throw e;
		}
	}

	@Override
	public Employee find(int eid) throws EmployeeNotFoundException, DirectoryException {
		try {
			System.out.println(new Date() + ": [DirectoryLogger] entering find employee");
			Employee result = target.find(eid);
			System.out.println(new Date() + ": [DirectoryLogger] leaving find employee");
			return result;
		} catch (DirectoryException e) {
			System.out.println(new Date() + ": [DirectoryLogger] received " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Employee> list() throws DirectoryException {
		try {
			System.out.println(new Date() + ": [DirectoryLogger] entering list employees");
			List<Employee> result = target.list();
			System.out.println(new Date() + ": [DirectoryLogger] leaving list employees");
			return result;
		} catch (DirectoryException e) {
			System.out.println(new Date() + ": [DirectoryLogger] received " + e.getMessage());
			throw e;
		}
	}

	@Override
	public List<Employee> search(Predicate<Employee> condition) throws DirectoryException {
		try {
			System.out.println(new Date() + ": [DirectoryLogger] entering search employees");
			List<Employee> results = target.search(condition);
			System.out.println(new Date() + ": [DirectoryLogger] leaving search employees");
			return results;
		} catch (DirectoryException e) {
			System.out.println(new Date() + ": [DirectoryLogger] received " + e.getMessage());
			throw e;
		}
	}

}
