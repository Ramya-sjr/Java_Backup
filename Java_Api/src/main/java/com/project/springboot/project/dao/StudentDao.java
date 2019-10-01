package com.project.springboot.project.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	if(count == 1)
		System.out.println("Student inserted...");
   }
	
	@Override
	public List<Student> listAllStudents() {
		
		String listAllQuery = "select *from students";
		return jdbcTemplate.query(listAllQuery, new StudentRowMapper());
		
	}

	@Override
	public List<Student> getStudentById(String studentInfo) {
		List<Student> student =  new ArrayList<>();
		try {
			String searchQuery = "select *from students where student_id like '%"+studentInfo+"%' or student_name like '%"+studentInfo+ "%' or student_dept like '%"+studentInfo+"%' or student_email like '%"+studentInfo+"%'";
			return jdbcTemplate.query(searchQuery, new StudentRowMapper());
//			return student;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;

	}
	
	@Override
	public void deleteStudentById(Integer studentId) {
		try {
			String deleteQuery = "delete from students where student_id=?";
			int count = jdbcTemplate.update(deleteQuery, studentId);
			
			if(count == 1) {
				System.out.println("Student deleted...");
			}
			else {
				System.out.println("no data");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("Invalid");
		}
		

	}

	

}
