package com.project.springboot.project.dao;

import com.project.springboot.project.model.Student;

public interface StudentDaoInterface {
	
	public abstract void createStudent(Student student);
	public abstract Student getStudentById(Integer studentId);
	public abstract void deleteStudentById(Integer studentId);

	
	

}
