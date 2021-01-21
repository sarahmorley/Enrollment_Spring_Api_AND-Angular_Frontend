package com.example.StudentEnrollment.contracts;
import com.example.StudentEnrollment.storage.EnrollmentAws;

public class EnrollmentContract {
    String courseId;
    String studentId;

    public EnrollmentContract(String courseId, String studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public EnrollmentContract(EnrollmentAws enrollmentItem){
        this.courseId = enrollmentItem.getCourseId();
        this.studentId = enrollmentItem.getStudentId();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
