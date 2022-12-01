package com.glarimy.dir.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.domain.Employee;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.EmployeeNotFoundException;
import com.glarimy.dir.api.exceptions.InvalidEmployeeException;

public class SortableDirectory implements Directory {
	private Directory target;

	public SortableDirectory(Directory target) {
		this.target = target;
	}

	@Override
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException {
		return target.add(employee);
	}

	@Override
	public Employee find(int eid) throws EmployeeNotFoundException, DirectoryException {
		return target.find(eid);
	}

	@Override
	public List<Employee> list() throws DirectoryException {
		return target.list();
	}
	
	@Override
	public List<Employee> search(Predicate<Employee> condition) throws DirectoryException {
		return target.search(condition);
	}

	public List<Employee> sort(Comparator<Employee> comparator) throws DirectoryException {
		List<Employee> employees = target.list();
		employees.sort(comparator);
		return employees;
	}

}
