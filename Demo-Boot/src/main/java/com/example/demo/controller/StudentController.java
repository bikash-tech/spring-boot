package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DAO.StudentDAO;
import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentDAO studentRepository;

	@PostMapping("/save")
	public StudentResponse saveStudent(@RequestBody Student student) {
		try {
			logger.info("Inside save Controler");
			Map<String, Object> map = new HashMap<>();
			if (student.getStudentId() == null) {
				student = studentRepository.save(student);
				map.put("student_id", student.getStudentId());
				return new StudentResponse(1000, "Student Saved Successfully", map);
			} else {
				Student studentUpdate = studentRepository.findByStudentId(student.getStudentId());
				studentUpdate.setStudentName(student.getStudentName());
				studentRepository.save(studentUpdate);
				return new StudentResponse(1000, "Student Updated Successfully", studentUpdate);
			}
		}catch(Exception e) {
			logger.error("Student object ::"+student);
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping("/getAllStudents")
	public StudentResponse getAllStudent() {
		try {
			logger.info("Ïnside get All Student Controler");
			List<Student> studentList = studentRepository.findAll();
			return new StudentResponse(2000, "Student retrived Successfully", studentList);
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}
