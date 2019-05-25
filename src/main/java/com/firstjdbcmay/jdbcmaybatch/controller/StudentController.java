package com.firstjdbcmay.jdbcmaybatch.controller;

import com.firstjdbcmay.jdbcmaybatch.impl.StudentImpl;
import com.firstjdbcmay.jdbcmaybatch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentImpl studentImpl;

    @GetMapping(value="/data")
    public List<Student> getData(){
        return studentImpl.getData();
    }
}
