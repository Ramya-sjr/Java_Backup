package com.project.springboot.project.dao;

import java.util.List;


import com.project.springboot.project.model.Student;

public interface StudentDaoInterface {
	
	
	
	public abstract void createStudent(Student student);
	public abstract List<Student> getStudentById(String studentInfo);
	public abstract void deleteStudentById(Integer studentId);
	public abstract List<Student> listAllStudents();
	
	

}
