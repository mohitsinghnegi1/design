package com.glarimy.dir.service;

import java.util.List;

import com.glarimy.dir.api.domain.Employee;

public interface DAO {
	public int create(Employee employee);
	public Employee read(int eid);
	public List<Employee> read();

}
