package com.pro.uas.dto;

public class ProgramsOffered {
	
	private String programName;
	private String description;
	private String eligibility;
	private int duration;
	private String degreeOffered;
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramname(String programname) {
		this.programName = programname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDegreeOffered() {
		return degreeOffered;
	}
	public void setDegreeOffered(String degreeoffered) {
		this.degreeOffered = degreeoffered;
	}
	@Override
	public String toString() {
		return "ProgramsOffered [programname=" + programName + ", description=" + description + ", eligibility="
				+ eligibility + ", duration=" + duration + ", degreeOffered=" + degreeOffered + "]";
	}
	

}
