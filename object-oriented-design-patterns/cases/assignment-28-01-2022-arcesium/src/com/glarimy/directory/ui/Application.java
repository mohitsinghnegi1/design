package com.glarimy.directory.ui;

import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.EmployeeDirectory;
import com.glarimy.directory.api.EmployeeNotFoundException;
import com.glarimy.directory.api.InvalidEmployeeException;
import com.glarimy.framework.Factory;
import com.glarimy.framework.SimpleFactory;

public class Application {

	public static void main(String[] args) {
		Factory factory = new SimpleFactory();
		EmployeeDirectory dir = (EmployeeDirectory) factory.get("directory");
		Employee e = new Employee();
		e.setName("Krishna");
		e.setPhoneNumber(9731423166L);

		try {
			Employee emp = dir.add(null);
			Employee result = dir.find(emp.getId());
			System.out.println("Found: " + result);
			System.out.println("List: " + dir.search(employee -> employee.getName().startsWith("Kri")));
			System.out.println("List: " + dir.search(employee -> employee.getPhoneNumber() == 1234));
			
		} catch (InvalidEmployeeException iee) {
			System.out.println("Invalid employee!");
		} catch (EmployeeNotFoundException enfe) {
			System.out.println("No such employee!");
		} catch (DirectoryException de) {
			System.out.println("System error .. try later!");
		}

	}

}
