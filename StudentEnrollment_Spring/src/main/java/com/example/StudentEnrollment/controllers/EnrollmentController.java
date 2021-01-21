package com.example.StudentEnrollment.controllers;
import com.example.StudentEnrollment.contracts.EnrollmentContract;
import com.example.StudentEnrollment.storage.EnrollmentAws;
import com.example.StudentEnrollment.storage.EnrollmentOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EnrollmentController {
    @Autowired
    private EnrollmentOperations enrollmentOperations;

    @PostMapping("/enrollments")
    public EnrollmentContract createEnrollment (@RequestBody EnrollmentContract newEnrollment) {
        EnrollmentAws newEnrollmentItem = enrollmentOperations.save(new EnrollmentAws(newEnrollment.getCourseId(), newEnrollment.getStudentId()));
        return new EnrollmentContract(newEnrollmentItem);
    }

    @GetMapping("/enrollments/{courseId}")
    public  List<EnrollmentContract> getStudentsInCourse (@PathVariable String courseId) {
        List<EnrollmentContract> enrollments = new ArrayList<>();
        List<EnrollmentAws> enrollmentItems = enrollmentOperations.findByHashKey(courseId);
        for(EnrollmentAws enrollmentItem: enrollmentItems){
            EnrollmentAws enrollment = enrollmentItem;
            enrollments.add(new EnrollmentContract(enrollment));
        }
        return enrollments;
    }

}
