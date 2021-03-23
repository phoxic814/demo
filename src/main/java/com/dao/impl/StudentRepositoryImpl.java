package com.dao.impl;

import com.dao.StudentRepository;
import com.dao.entity.Student;
import com.dao.jpa.StudentEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private StudentEntityRepository studentEntityRepository;

    @Override
    public List<Student> all() {
        return studentEntityRepository.findAll();
    }

    @Override
    public Student one(String id) {
        Optional<Student> student = studentEntityRepository.findById(id);
        return student.isPresent() ? student.get() : new Student();
    }


}
