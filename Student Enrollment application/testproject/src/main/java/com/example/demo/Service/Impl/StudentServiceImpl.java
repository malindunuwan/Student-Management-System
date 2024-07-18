package com.example.demo.Service.Impl;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepo;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public Student create(Student student){
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public String deleteStudent(Integer id) {
        studentRepo.deleteById(id);
        return "Record Deleted";
    }


}

