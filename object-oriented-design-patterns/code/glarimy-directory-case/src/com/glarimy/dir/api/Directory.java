package com.glarimy.dir.api;

import java.util.List;
import java.util.function.Predicate;

import com.glarimy.dir.api.domain.Employee;
import com.glarimy.dir.api.exceptions.DirectoryException;
import com.glarimy.dir.api.exceptions.EmployeeNotFoundException;
import com.glarimy.dir.api.exceptions.InvalidEmployeeException;

/**
 * Directory holds the list of employees. 
 * 
 * @author glarimy
 *
 */
public interface Directory {
	/**
	 * Adds a valid employee into the system
	 * 
	 * @param employee a valid employee
	 * @return newly generated employee id
	 * @throws InvalidEmployeeException if the employee name is empty or phone number is not having 10 digits and a positive number
	 * @throws DirectoryException for internal errors
	 */
	public int add(Employee employee) throws InvalidEmployeeException, DirectoryException;

	/**
	 * 
	 * @param eid
	 * @return
	 * @throws EmployeeNotFoundException
	 * @throws DirectoryException
	 */
	public Employee find(int eid) throws EmployeeNotFoundException, DirectoryException;
	
	/**
	 * 
	 * @return
	 * @throws DirectoryException
	 */
	public List<Employee> list() throws DirectoryException;
	
	/**
	 * 
	 * @param condition
	 * @return
	 * @throws DirectoryException
	 */
	
	public List<Employee> search(Predicate<Employee> condition) throws DirectoryException;
}
