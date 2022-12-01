package com.glarimy.directory.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.glarimy.directory.api.Employee;

public class InMemoryStorage implements Storage {
	private Map<Integer, Employee> employees;
	private static int ID = 0;

	public InMemoryStorage() {
		employees = new HashMap<Integer, Employee>();
	}

	@Override
	public Employee create(Employee e) {
		Employee entity = new Employee(++ID, e.getName(), e.getPhoneNumber());
		employees.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public Employee read(int id) {
		return employees.get(id);
	}

	@Override
	public List<Employee> list() {
		return new ArrayList<Employee>(this.employees.values());
	}

}
