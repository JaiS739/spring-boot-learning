package com.restAPI.learningRestAPI.controller;

import com.restAPI.learningRestAPI.dto.StudentDto;
import com.restAPI.learningRestAPI.entity.Student;
import com.restAPI.learningRestAPI.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

}
