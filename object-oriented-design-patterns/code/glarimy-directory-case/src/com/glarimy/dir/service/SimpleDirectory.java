package com.glarimy.dir.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.domain.Employee;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.EmployeeNotFoundException;
import com.glarimy.dir.api.exceptions.InvalidEmployeeException;
import com.glarimy.factory.Wire;

@Wire(target = "dao")
public class SimpleDirectory implements Directory {
	private DAO dao;

	public SimpleDirectory(DAO dao) throws Exception {
		this.dao = dao;
	}

	@Override
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException {
		return dao.create(employee);
	}

	@Override
	public Employee find(int eid) throws EmployeeNotFoundException, DirectoryException {
		Employee employee = dao.read(eid);
		if (employee == null)
			throw new EmployeeNotFoundException();
		return employee;
	}

	@Override
	public List<Employee> list() throws DirectoryException {
		return dao.read();
	}
	
	@Override
	public List<Employee> search(Predicate<Employee> condition) throws DirectoryException {
		List<Employee> list = list();
		List<Employee> results = new ArrayList<>();
		for(Employee e: list) {
			if(condition.test(e)) {
				results.add(e);
			}
		}
		return results;
	}

}
