package com.pro.uas.dao;

import java.util.List;

import com.pro.uas.dto.Application;
import com.pro.uas.dto.ProgrammsScheduled;
import com.pro.uas.dto.ProgramsOffered;
import com.pro.uas.dto.Users;

public interface UniversityManagementDAO {

	public Users login(String loginId, String password, String role);
	
	public boolean addProgramOffered(ProgramsOffered po);
	
	public boolean updateProgramOffered(ProgramsOffered po);
	
	public boolean deleteProgramOffered(String programName);
	
	public List<ProgramsOffered> listAllPrograms();
	
	public boolean createScheduledProgram(ProgrammsScheduled Ps);
	
	public boolean updateScheduledProgram(ProgrammsScheduled Ps);
	
	public boolean deleteScheduledProgram(int schProgrammId);
	
	public List<ProgrammsScheduled> listAllScheduledPrograms();
	
	public boolean applyApplication(Application ap);
	
	public boolean deleteApplication(int applicationid);
	
	public boolean updateApplication(String status, String interviewdate, int applicationid);
	
	public List<Application> listAllApplications();
	
	public int getApplicationId(String email);



}
