package com.dao;

import com.dao.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> all();

    Student one(String id);
}
