package com.example.demo.Service;

import com.example.demo.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student create(Student student);

    public List<Student> getAllStudents();

    public String deleteStudent(Integer id);

}