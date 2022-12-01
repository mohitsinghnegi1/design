package com.glarimy.directory.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.directory.api.Directory;
import com.glarimy.directory.api.DirectoryException;
import com.glarimy.directory.api.Employee;
import com.glarimy.directory.api.InvalidRequestException;
import com.glarimy.directory.api.NewEmployee;
import com.glarimy.directory.domain.EmployeeEntity;

public class SimpleDirectory implements Directory {
	private Map<Integer, EmployeeEntity> employees;

	public SimpleDirectory() {
		employees = new HashMap<Integer, EmployeeEntity>();
	}

	@Override
	public Employee add(NewEmployee e) throws InvalidRequestException, DirectoryException {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setId(employees.size() + 1);
		entity.setName(e.getName());
		entity.setPhone(e.getPhone());

		employees.put(entity.getId(), entity);

		Employee emp = new Employee();
		emp.setId(entity.getId());
		emp.setName(entity.getName());
		emp.setPhone(entity.getPhone());
		
		return emp;

	}

}
