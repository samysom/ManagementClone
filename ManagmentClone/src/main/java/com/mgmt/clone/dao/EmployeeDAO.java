package com.mgmt.clone.dao;

import com.mgmt.clone.dto.Employee;

public interface EmployeeDAO {

	public Employee login(int id,String password);
	
	public boolean addEmployee(Employee emp);
	
	public boolean delete(int id,String password);
	
	public Employee update(Employee emp);
	
}