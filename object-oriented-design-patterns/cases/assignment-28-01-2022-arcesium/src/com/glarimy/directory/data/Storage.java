package com.glarimy.directory.data;

import java.util.List;

import com.glarimy.directory.api.Employee;

public interface Storage {
	public Employee create(Employee e);
	public Employee read(int id);
	public List<Employee> list();
}
