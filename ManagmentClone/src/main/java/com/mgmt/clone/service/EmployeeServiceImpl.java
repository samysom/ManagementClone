package com.mgmt.clone.service;

import com.mgmt.clone.dao.EmployeeDAOImpl;
import com.mgmt.clone.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAOImpl impl = new EmployeeDAOImpl();
	@Override
	public Employee login(int id, String password) {
		Employee emp = impl.login(id, password);
		
		if(emp!=null)
		{
			return emp;
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		boolean result = impl.addEmployee(emp);
		if(result)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id, String password) {
		boolean result = impl.delete(id, password);
		if(result)
		{
			return true;
		}
		return false;
	}

	@Override
	public Employee update(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

}