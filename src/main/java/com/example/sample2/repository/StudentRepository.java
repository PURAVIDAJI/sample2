package com.example.sample2.repository;

import com.example.sample2.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentRepository {

    List<Student> findAll();
    Student findById(int id);
    void updateStudent(Student student);
    int insertStudent (Student student);
    Student deleteById(int id);


}
