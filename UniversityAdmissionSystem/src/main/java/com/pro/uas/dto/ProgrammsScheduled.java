package com.pro.uas.dto;

import java.sql.Date;

public class ProgrammsScheduled {

	private int schprogramid;
	private String programname;
	private String location;
	private String startdate;
	private String enddate;
	private int sessionsperweek;
	public int getSchprogramid() {
		return schprogramid;
	}
	public void setSchprogramid(int schprogramid) {
		this.schprogramid = schprogramid;
	}
	public String getProgramname() {
		return programname;
	}
	public void setProgramname(String programname) {
		this.programname = programname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getSessionsperweek() {
		return sessionsperweek;
	}
	public void setSessionsperweek(int sessionsperweek) {
		this.sessionsperweek = sessionsperweek;
	}
	@Override
	public String toString() {
		return "ProgrammsScheduled [schprogramid=" + schprogramid + ", programname=" + programname + ", location="
				+ location + ", startdate=" + startdate + ", enddate=" + enddate + ", sessionsperweek="
				+ sessionsperweek + "]";
	}
	

}
