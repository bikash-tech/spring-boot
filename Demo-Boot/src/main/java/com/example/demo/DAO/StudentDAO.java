package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentDAO extends JpaRepository<Student, Integer>{
	public Student findByStudentId(Integer id);
}
