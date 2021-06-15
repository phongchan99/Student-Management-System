package com.example.project1.controller;

import com.example.project1.entity.Course;
import com.example.project1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/courseById/{id}")
    public Course courseById(@PathVariable int id) {
        return service.courseById(id);
    }

    @GetMapping("/courses")
    public List<Course> courses() {
        return service.courses();
    }

    @PostMapping("/addCourse")
    public Course addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    @PostMapping("/addCourses")
    public List<Course> addCourses(@RequestBody List<Course> courses) {
        return service.addCourses(courses);
    }

    @PutMapping("/updateCourse")
    public Course updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable int id) {
        return service.deleteCourse(id);
    }
}
