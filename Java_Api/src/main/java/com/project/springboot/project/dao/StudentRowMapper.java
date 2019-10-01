package com.project.springboot.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.project.springboot.project.model.Student;


public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Student student = new Student();
		student.setStudentId(rs.getInt("student_id"));
        student.setStudentName(rs.getString("student_name"));
        student.setStudentDept(rs.getString("student_dept"));
        student.setStudentEmail(rs.getString("student_email"));
		return student;
	}
	
	

}
