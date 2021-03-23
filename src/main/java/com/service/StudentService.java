package com.service;

import com.dao.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> all();

    Student one(String id);
}
