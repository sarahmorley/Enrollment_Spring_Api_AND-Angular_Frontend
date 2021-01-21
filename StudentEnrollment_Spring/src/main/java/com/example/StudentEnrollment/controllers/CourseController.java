package com.example.StudentEnrollment.controllers;
import com.example.StudentEnrollment.contracts.CourseContract;
import com.example.StudentEnrollment.storage.CourseAws;
import com.example.StudentEnrollment.storage.CourseOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseOperations courseOperations;

    @GetMapping("/courses")
    public List<CourseContract> listCourses() {
        List<CourseContract> courses = new ArrayList<>();
        List<CourseAws> courseItems = courseOperations.findAll();
        for (CourseAws courseItem: courseItems){
            CourseAws course = courseItem;
            courses.add(new CourseContract(course));
        }
        return courses;
    }

    @PostMapping("/courses")
    public CourseContract createCourse (@RequestBody CourseContract newCourse) {
        CourseAws newCourseItem = courseOperations.save(new CourseAws(newCourse.getName(), newCourse.getDescription()));
        return new CourseContract(newCourseItem);
    }
}
