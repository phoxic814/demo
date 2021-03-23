package com.service.impl;

import com.dao.StudentRepository;
import com.dao.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> all() {
        return studentRepository.all();
    }

    @Override
    public Student one(String id) {
        return studentRepository.one(id);
    }
}
