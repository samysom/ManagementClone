package com.pro.uas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.pro.uas.dto.Application;
import com.pro.uas.dto.ProgrammsScheduled;
import com.pro.uas.dto.ProgramsOffered;
import com.pro.uas.dto.Users;
import com.pro.uas.repositories.URL;

public class UniversityDAOJDBCImpl implements UniversityManagementDAO {

	PreparedStatement pstmt = null;
	Connection con = null;
	URL url = new URL();
	ProgramsOffered po = new ProgramsOffered();
	ProgrammsScheduled ps = new ProgrammsScheduled();
	Application ap = new Application();
	ResultSet rs = null;
	Users us = new Users();
	Statement stmt = null;
	List<ProgramsOffered> lst=new LinkedList<ProgramsOffered>();
	List<ProgrammsScheduled> lst1=new LinkedList<ProgrammsScheduled>();
	List<Application> lst2=new LinkedList<Application>();
	
	
	@Override
	public Users login(String loginId, String password, String role) {
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(url.getURL());
		
		String query = "select * from ums where Login_id = ? and Password = ? and  Role=?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,loginId);
		pstmt.setString(2,password);
		pstmt.setString(3,role);
		
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			String id1 = rs.getString("loginId");
			String name = rs.getString("role");
			
			us.setLoginId(id1);
			us.setRole(name);
			
			return us;
			
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
	public boolean addProgramOffered(ProgramsOffered po) {
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		
		String query = "insert into Programs_Offered values(?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1,po.getProgramName());
		pstmt.setString(2,po.getDescription());
		pstmt.setString(3,po.getEligibility());
		pstmt.setInt(4,po.getDuration());
		pstmt.setString(5,po.getDegreeOffered());
		
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
	public boolean  deleteProgramOffered(String programName) {
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		String query = "delete from ProgramsOffered where ProgramName = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, programName);
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
	public List<ProgramsOffered> listAllPrograms() {
		
		try 
		{
			String query="SELECT * FROM Programs_offered";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);


			while(rs.next()) 
			{    
			
				po.setProgramname(rs.getString("ProgramName"));
				po.setDescription(rs.getString(" Description"));
				po.setEligibility(rs.getString("Applicant_eligibility"));
				po.setDuration(rs.getInt("Duration"));
				po.setDegreeOffered(rs.getString("Degree_certificate_offered"));
				
				
				lst.add(po);
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public boolean createScheduledProgram(ProgrammsScheduled Ps) {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		
		String query = "insert into Programms_Scheduled values(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,ps.getSchprogramid());
		pstmt.setString(1,ps.getProgramname());
		pstmt.setString(2,ps.getLocation());
		pstmt.setString(3,ps.getStartdate());
		pstmt.setString(4,ps.getEnddate());
		pstmt.setInt(5,ps.getSessionsperweek());
		
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
	public boolean updateScheduledProgram(ProgrammsScheduled Ps) {
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			con = DriverManager.getConnection(url.getURL());
			
			String querry="UPDATE ums SET   ProgrammName=? , Location=? ,  Start_date=? ,  End_date=? ,  Sessions_per_week=?"
					+ " WHERE  Scheduled_program_id=?";
					
			
			pstmt.setString(1,ps.getProgramname());
			pstmt.setString(2,ps.getLocation());
			pstmt.setString(3,ps.getStartdate());
			pstmt.setString(4,ps.getEnddate());
			pstmt.setInt(5,ps.getSessionsperweek());
			pstmt.setInt(6,ps.getSchprogramid());
			
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			
			}		
		}catch(Exception e)
		{
		
			e.printStackTrace();
			return false;
		}
		return false;
	}
	

	@Override
	public boolean deleteScheduledProgram(int schProgrammId) {
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		String query = "delete from Programms_Scheduled where Scheduled_program_id = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,schProgrammId );
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
	public List<ProgrammsScheduled> listAllScheduledPrograms() {
		
		try 
		{
			String query="SELECT * FROM Programms_Scheduled";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);


			while(rs.next()) 
			{    
			
				ps.setSchprogramid(rs.getInt("Scheduled_program_id"));
				ps.setProgramname(rs.getString("ProgrammName"));
				ps.setLocation(rs.getString("Location"));
				ps.setStartdate(rs.getString("Start_date"));
				ps.setEnddate(rs.getString("End_date"));
				ps.setSessionsperweek(rs.getInt("Sessions_per_week"));
				
				
				
				lst1.add(ps);
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
		

	@Override
	public boolean applyApplication(Application ap) {
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url.getURL());
		
		String query = "insert into Application values(?,?,?,?,?)";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1,ap.getApplicationid());
		pstmt.setString(2,ap.getName());
		pstmt.setString(3,ap.getDateofbirth());
		pstmt.setString(4,ap.getQualification());
		pstmt.setInt(5,ap.getMarks());
		pstmt.setString(6,ap.getGoals());
		pstmt.setString(7,ap.getEmailid());
		pstmt.setInt(8,ap.getSchprogramid());
		pstmt.setString(9,ap.getStatus());
		pstmt.setString(9,ap.getInterviewdate());
		
		
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
	public boolean deleteApplication(int applicationid) {

		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(url.getURL());
		
		String query = "delete from Application where Application_id = ?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, applicationid);
		
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
	public boolean updateApplication(String status, String interviewdate, int applicationid) {
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			con = DriverManager.getConnection(url.getURL());
			
			String querry="UPDATE Application SET  Status=? , Date_of_interview=?"
					+ " WHERE  applicationid=?";
					
					
			pstmt=con.prepareStatement(querry);
			pstmt.setString(1,status);
			pstmt.setString(2,interviewdate);
			pstmt.setInt(3,applicationid);
			
			
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			
			}		
		}catch(Exception e)
		{
		
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<Application> listAllApplications() {
		try 
		{
			String query="SELECT * FROM Programms_Scheduled";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);


			while(rs.next()) 
			{    
			
				ap.setApplicationid(rs.getInt("Application_id"));
				ap.setName(rs.getString("Full_name"));
				ap.setDateofbirth(rs.getString("Date_of_birth"));
				ap.setQualification(rs.getString(" Hishest_qualification"));
				ap.setMarks(rs.getInt("Marks_obtained"));
				ap.setGoals(rs.getString(" Goals"));
				ap.setEmailid(rs.getString("Email_id"));
				ap.setSchprogramid(rs.getInt("Scheduled_program_id"));
				ap.setStatus(rs.getString("Status"));
				ap.setInterviewdate(rs.getString("Date_of_interview"));
				
				
				
				
				lst2.add(ap);
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) 
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null) 
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
		

	@Override
	public int getApplicationId(String email) {
		
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url.getURL());

			String query = "select * from Application where Email_id=? ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,email);
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				int no = rs.getInt("applicationid");
				
				System.out.println(no);
				
				System.out.println("***************");

			}
		
		}catch(Exception e)
		{
			
		   e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public boolean updateProgramOffered(ProgramsOffered po) {
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
	
			con = DriverManager.getConnection(url.getURL());
			
			String querry="UPDATE Programs_Offered SET  Description=? , Applicant_eligibility=? , Duration=? , Degree_certificate_offered=?"
					+ " WHERE ProgramName=?";
					
					
			pstmt=con.prepareStatement(querry);
			pstmt.setString(1,po.getDescription());
			pstmt.setString(2,po.getEligibility());
			pstmt.setInt(3,po.getDuration());
			pstmt.setString(4,po.getDegreeOffered());
			pstmt.setString(5,po.getProgramName());
			
			pstmt = con.prepareStatement(querry);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			
			}		
		}catch(Exception e)
		{
		
			e.printStackTrace();
			return false;
		}
		return false;
	}

	
}	
	