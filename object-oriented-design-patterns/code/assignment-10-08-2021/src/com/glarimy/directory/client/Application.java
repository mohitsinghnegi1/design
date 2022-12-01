package com.glarimy.directory.client;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;
import com.glarimy.directory.service.SimpleDirectory;

public class Application {

	public static void main(String[] args) {
		Directory dir = new SimpleDirectory();
		NewEmployee emp = new NewEmployee();
		emp.setName("Krishna");
		emp.setPhone(123456);
		try {
			Employee employee = dir.add(emp);
			System.out.println("Added new employee with ID: " + employee.getId());
		} catch (InvalidRequestException e) {
			e.printStackTrace();
		} catch (DirectoryException e) {
			e.printStackTrace();
		}
	}

}
