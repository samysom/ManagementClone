package com.mgmt.clone.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mgmt.clone.dto.Employee;
import com.mgmt.clone.service.EmployeeService;
import com.mgmt.clone.service.EmployeeServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("userid"));
		String password = req.getParameter("password");
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		Employee emp = service.login(id, password);
		RequestDispatcher dis = req.getRequestDispatcher("/Homepage.jsp");
		if(emp!=null)
		{
			HttpSession session = req.getSession();
			req.setAttribute("emp",emp);
			dis.forward(req,resp);
		}
		else
		{
			resp.sendRedirect("./login.jsp");
		}
		
		
		
	}
	
}