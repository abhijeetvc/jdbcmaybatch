package com.firstjdbcmay.jdbcmaybatch.repos;

import com.firstjdbcmay.jdbcmaybatch.model.Student;

import java.util.List;

public interface StudentRepo {

    List<Student> getData();
}
