package com.example.project1.service;

import com.example.project1.entity.Course;
import com.example.project1.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course courseById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Course> courses() {
        return repository.findAll();
    }

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> addCourses(List<Course> courses) {
        return repository.saveAll(courses);
    }

    public String deleteCourse(int id) {
        repository.deleteById(id);
        return "Course " + id + " removed";
    }

    public Course updateCourse(Course course) {
        Course existCourse = repository.findById(course.getId()).orElse(null);
        existCourse.setName(course.getName());
        existCourse.setCredit(course.getCredit());
        return repository.save(existCourse);
    }
}
