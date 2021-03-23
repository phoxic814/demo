package com.controller;

import com.dao.entity.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin(origins = {"*"})
public class Controller {

    @Autowired
    private StudentService studentService;

    @GetMapping("student/all")
    public List<Student> all() {
        return studentService.all();
    }

    @GetMapping("student")
    public Student one(@RequestParam("id") String id) {
        return studentService.one(id);
    }
}
