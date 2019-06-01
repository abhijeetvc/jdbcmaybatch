package com.firstjdbcmay.jdbcmaybatch.controller;

import com.firstjdbcmay.jdbcmaybatch.impl.StudentImpl;
import com.firstjdbcmay.jdbcmaybatch.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentImpl studentImpl;

    @GetMapping(value="/data")
    public List<Student> getData(){
        return studentImpl.getData();
    }

    @GetMapping(value="/data1/{id}")
    public Student getData1(@PathVariable Integer id){
        return studentImpl.getStudent(id);
    }

    @GetMapping(value="/data2/{id}/{name}")
    public String getData1(@PathVariable Integer id,
                            @PathVariable String name){
        return studentImpl.updateStudent(id,name);
    }

    @PostMapping(value="/save")
    public String saveData(@RequestBody Student student){

        String s=studentImpl.saveData(student);
        return s;
    }

}
