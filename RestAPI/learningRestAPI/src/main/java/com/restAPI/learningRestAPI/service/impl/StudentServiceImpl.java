package com.restAPI.learningRestAPI.service.impl;

import com.restAPI.learningRestAPI.dto.StudentDto;
import com.restAPI.learningRestAPI.entity.Student;
import com.restAPI.learningRestAPI.repository.StudentRepository;
import com.restAPI.learningRestAPI.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudent() {

        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }
}
