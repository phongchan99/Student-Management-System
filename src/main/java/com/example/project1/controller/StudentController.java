package com.example.project1.controller;

import com.example.project1.entity.Student;
import com.example.project1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/studentById/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.findStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return service.findStudents();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    @PostMapping("/addStudents")
    public List<Student> addStudents(@RequestBody List<Student> students) {
        return service.addStudents(students);
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}
