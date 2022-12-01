package com.glarimy.directory.api;

import java.util.List;
import java.util.function.Predicate;

public interface EmployeeDirectory {
	public Employee add(Employee e) throws InvalidEmployeeException, DirectoryException;

	public Employee find(int id) throws EmployeeNotFoundException, DirectoryException;

	public List<Employee> search(Predicate<Employee> c) throws DirectoryException;
}
