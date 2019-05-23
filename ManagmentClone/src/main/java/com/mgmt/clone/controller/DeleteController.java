package com.mgmt.clone.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgmt.clone.dao.EmployeeDAOImpl;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeDAOImpl  impl = new EmployeeDAOImpl();
		int id = Integer.parseInt(req.getParameter("id"));
		String password = req.getParameter("password");
		boolean result = impl.delete(id, password);
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