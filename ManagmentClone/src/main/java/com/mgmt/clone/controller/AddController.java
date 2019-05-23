package com.mgmt.clone.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgmt.clone.dto.Employee;
import com.mgmt.clone.service.EmployeeServiceImpl;


public class AddController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		Employee emp = new Employee();
		EmployeeServiceImpl impl = new EmployeeServiceImpl();
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String pass = req.getParameter("password");
		double sal = Double.parseDouble(req.getParameter("salary"));
		
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(pass);
		emp.setSalary(sal);
		boolean result  = impl.addEmployee(emp);
		if(result)
		{
			resp.sendRedirect("SuccessEmp.jsp");
		}
		else
		{
			resp.sendRedirect("Failed.jsp");
		}
		
	}
}