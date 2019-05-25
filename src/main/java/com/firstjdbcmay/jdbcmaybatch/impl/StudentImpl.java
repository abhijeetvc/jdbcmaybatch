package com.firstjdbcmay.jdbcmaybatch.impl;


import com.firstjdbcmay.jdbcmaybatch.model.Student;
import com.firstjdbcmay.jdbcmaybatch.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImpl implements StudentRepo {

    @Autowired
   private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getData() {

        String sql="select * from student";
        List<Student> list=jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Student.class));
        return list;
    }
}
