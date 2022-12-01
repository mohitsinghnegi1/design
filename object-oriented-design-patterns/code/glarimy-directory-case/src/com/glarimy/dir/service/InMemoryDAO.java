package com.glarimy.dir.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.glarimy.dir.api.domain.Employee;

public class InMemoryDAO implements DAO {
	private Map<Integer, Employee> entries;
	private AtomicInteger id;

	public InMemoryDAO() {
		entries = new HashMap<Integer, Employee>();
		id = new AtomicInteger();
	}

	@Override
	public int create(Employee employee){
		employee.setEid(id.incrementAndGet());
		entries.put(employee.getEid(), employee);
		return employee.getEid();
	}

	@Override
	public Employee read(int eid) {
		return entries.get(eid);
	}

	@Override
	public List<Employee> read() {
		return new ArrayList<Employee>(entries.values());
	}

}
