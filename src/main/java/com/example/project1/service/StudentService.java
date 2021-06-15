package com.example.project1.service;

import com.example.project1.entity.Student;
import com.example.project1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class StudentService implements Serializable {

    @Autowired
    private StudentRepository repository;

    public Student studentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> findStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> addStudents(List<Student> students) {
        return repository.saveAll(students);
    }

    public String deleteStudent(int id) {
        repository.deleteById(id);
        return "Student " + id + " removed.";
    }

    public Student updateStudent(Student student) {
        Student existStudent = new Student();
        existStudent.setName(student.getName());
        return repository.save(existStudent);
    }
}
