package com.glarimy.dir.service;

import java.util.Date;
import java.util.List;

import com.glarimy.dir.api.domain.Employee;

public class DAOLogger implements DAO {
	private DAO target;

	public DAOLogger(DAO target) {
		this.target = target;
	}

	@Override
	public int create(Employee employee) {
		System.out.println(new Date() + ": [DAOLogger] entering create employee");
		int result = target.create(employee);
		System.out.println(new Date() + ": [DAOLogger] leaving create employee");
		return result;
	}

	@Override
	public Employee read(int eid) {
		System.out.println(new Date() + ": [DAOLogger] entering read employee");
		Employee result = target.read(eid);
		System.out.println(new Date() + ": [DAOLogger] leaving read employee");
		return result;
	}

	@Override
	public List<Employee> read() {
		System.out.println(new Date() + ": [DAOLogger] entering read employees");
		List<Employee> results = target.read();
		System.out.println(new Date() + ": [DAOLogger] leaving read employees");
		return results;
	}

}
