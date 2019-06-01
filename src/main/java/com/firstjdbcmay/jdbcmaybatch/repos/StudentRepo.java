package com.firstjdbcmay.jdbcmaybatch.repos;

import com.firstjdbcmay.jdbcmaybatch.model.Student;

import java.util.List;

public interface StudentRepo {

    List<Student> getData();

    Student getStudent(Integer id);

    String updateStudent(Integer id,String name);

    String saveData(Student student);
}
