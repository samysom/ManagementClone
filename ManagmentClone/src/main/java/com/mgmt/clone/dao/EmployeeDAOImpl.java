package com.mgmt.clone.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mgmt.clone.dto.Employee;
import com.mgmt.clone.repo.URL;

public class EmployeeDAOImpl implements EmployeeDAO{

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	URL url = new URL();
	Employee emp = new Employee();
	
	
	@Override
	public Employee login(int id, String password)  {
	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(url.getURL());
		
		String query = "select * from employee where id = ? and password = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,id);
		pstmt.setString(2,password);
		
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			double sal = rs.getDouble("salary");
			String pass= rs.getString("password");
			
			emp.setId(id1);
			emp.setName(name);
			emp.setSalary(sal);
			emp.setPassword(pass);
			
			return emp;
			
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		   	
		}
		finally
		{
            if(con!=null)
            {
            	try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if(pstmt!=null)
            {
            	try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            if(rs!=null)
            {
            	try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
		}
		return null;
	}

	@Override
	public boolean addEmployee(Employee emp) {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		
		String query = "insert into employee values(?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,emp.getId());
		pstmt.setString(2,emp.getName());
		pstmt.setString(3,emp.getPassword());
		pstmt.setDouble(4,emp.getSalary());
		int count = pstmt.executeUpdate();
		if(count>0)
		{
			return true;
		}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		    return false;   
		}
		return false;
	}

	@Override
	public boolean delete(int id, String password) {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		String query = "delete from employee where id = ? and password = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,id);
		pstmt.setString(2,password);
		int count = pstmt.executeUpdate();
		if(count>0)
		{
			return true;
		}
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		    return false;
		}
		return false;
	}

	@Override
	public Employee update(Employee emp) {
		
		
		
		return null;
	}

	
}