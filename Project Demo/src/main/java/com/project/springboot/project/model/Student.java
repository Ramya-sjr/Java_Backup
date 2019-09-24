package com.project.springboot.project.model;

public class Student {
	
	private Integer studentId;
	private String studentName;
	private String studentDept;
	private String studentEmail;
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentDept() {
		return studentDept;
	}
	
	public void setStudentDept(String studentDept) {
		this.studentDept = studentDept;
	}
	
	public String getStudentEmail() {
		return studentEmail;
	}
	
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDept=" + studentDept
				+ ", studentEmail=" + studentEmail + "]";
	}
	
	
	
	
	

}
