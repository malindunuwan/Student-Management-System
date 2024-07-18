package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v2")
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get")
    public String get(){

        return "enroll";
    }

    @PostMapping("/student/enroll")
    public String saveStudent(@ModelAttribute Student student){
        studentService.create(student);
        return "enroll";
    }

    @GetMapping("/ren/data")
    public String getStudents(Model model){
        List<Student> students=studentService.getAllStudents();
        model.addAttribute("students",students);
        return "dashboard";
    }

    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Integer id){

        studentService.deleteStudent(id);

        return "dashboard";
    }

}
