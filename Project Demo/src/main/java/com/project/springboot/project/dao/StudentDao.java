package com.project.springboot.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.springboot.project.model.Student;

@Repository
public class StudentDao implements StudentDaoInterface {
   
	@Autowired
	private JdbcTemplate jdbcTemplate;
  
	@Override
	public void createStudent(Student student) {
		 
	String insertQuery = "insert into students (student_name,student_dept,student_email) values (?,?,?)";
	int count = jdbcTemplate.update(insertQuery, student.getStudentName(),student.getStudentDept(),student.getStudentEmail());
	
	if(count == 1) {
		System.out.println("Student inserted...");
	}
	
	}

	@Override
	public Student getStudentById(Integer studentId) {
		String searchQuery = "select *from students where student_id=?";
		Student student = jdbcTemplate.queryForObject(searchQuery, new StudentRowMapper(), studentId);
		return student;
		
	}
	
	@Override
	public void deleteStudentById(Integer studentId) {
		String deleteQuery = "delete from students where student_id=?";
		int count = jdbcTemplate.update(deleteQuery, studentId);
		
		if(count == 1) {
			System.out.println("Student deleted...");
		}
		

	}

	

}
