package com.example.student;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final List<Student> studentList = Arrays.asList(
            new Student(1, "Bikash Panigrahi"),
            new Student(2, "Ramesh Power"),
            new Student(3, "James Bond")
    );
    @RequestMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return studentList.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist."));
    }
}


