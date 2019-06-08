package com.firstjdbcmay.jdbcmaybatch.impl;


import com.firstjdbcmay.jdbcmaybatch.model.Student;
import com.firstjdbcmay.jdbcmaybatch.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Override
    public Student getStudent(Integer id) {

        String sql="select * from student where id=?";
        Student s=jdbcTemplate.queryForObject(sql,new Object[]{id},
                new BeanPropertyRowMapper<>(Student.class));
        return s;
    }

    @Override
    public String updateStudent(Integer id, String name) {

        String sql="update student set name=? where id=?";

        jdbcTemplate.update(sql,new Object[]{name,id});
        return "Data updated";
    }

    @Override
    public String saveData(Student student) {

        String sql="insert into student values(?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getId(),student.getName()});
        return "Data saved";
    }

    @Override
    public List<Map<String,Object>> getCombinedData() {

        String sql="select a.id,a.name as studentname,b.name as deptname from " +
                "student a,dept b where a.deptId=b.id";
        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

}
