package com.pro.uas.dto;

public class Application {
	
	private int applicationid;
	private String name;
	private String dateofbirth;
	private String qualification;
	private int marks;
	private String goals;
	private String emailid;
	private int schprogramid;
	private String status;
	private String interviewdate;
	public int getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(int applicationid) {
		this.applicationid = applicationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getSchprogramid() {
		return schprogramid;
	}
	public void setSchprogramid(int schprogramid) {
		this.schprogramid = schprogramid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInterviewdate() {
		return interviewdate;
	}
	public void setInterviewdate(String interviewdate) {
		this.interviewdate = interviewdate;
	}
	@Override
	public String toString() {
		return "Application [applicationid=" + applicationid + ", name=" + name + ", dateofbirth=" + dateofbirth
				+ ", qualification=" + qualification + ", marks=" + marks + ", goals=" + goals + ", emailid=" + emailid
				+ ", schprogramid=" + schprogramid + ", status=" + status + ", interviewdate=" + interviewdate + "]";
	}
	
	
}

