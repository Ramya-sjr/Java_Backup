package com.project.springboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.springboot.project.dao.StudentDaoInterface;
import com.project.springboot.project.model.Student;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController {
	
	@Autowired
	private StudentDaoInterface studentDao;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@GetMapping(value = "/listall" , produces = "application/json")
	private List<Student> listAll(){
		return studentDao.listAllStudents();
		
	}
	
	@PostMapping("/insert")
      private Student createStudent(@RequestBody Student student) {
		studentDao.createStudent(student);
		return student;
		
	}
	
	@GetMapping("/search/{studentInfo}")
	 private String searchById(@PathVariable String studentInfo) throws JsonProcessingException {
		List<Student> student = studentDao.getStudentById(studentInfo);
		System.out.println("Info : " + student);
		String studentAsString = objectMapper.writeValueAsString(student);
		return studentAsString;
		
	}
	
	@DeleteMapping("/delete/{studentId}")
	private String deleteById(@PathVariable int studentId) {
		studentDao.deleteStudentById(studentId);
		return "Student detail deleted ";
	}
	
	

}
