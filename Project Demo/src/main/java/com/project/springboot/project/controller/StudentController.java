package com.project.springboot.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboot.project.dao.StudentDaoInterface;
import com.project.springboot.project.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentDaoInterface studentDao;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("/insert")
      private String createStudent(@RequestBody Student student) {
		studentDao.createStudent(student);
		return "Query affected";
		
	}
	
	@GetMapping("/search/{studentId}")
	 private String searchById(@PathVariable int studentId) throws JsonProcessingException {
		Student student = studentDao.getStudentById(studentId);
		System.out.println("Info : " + student);
		String studentAsString = objectMapper.writeValueAsString(student);
		return studentAsString;
		
	}
	
	@GetMapping("/delete/{studentId}")
	private String deleteById(@PathVariable int studentId) {
		studentDao.deleteStudentById(studentId);
		return "Student detail deleted ";
	}
	
	

}
