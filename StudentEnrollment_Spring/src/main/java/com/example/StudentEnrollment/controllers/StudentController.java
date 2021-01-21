package com.example.StudentEnrollment.controllers;
import com.example.StudentEnrollment.contracts.StudentContract;
import com.example.StudentEnrollment.storage.StudentAws;
import com.example.StudentEnrollment.storage.StudentOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentOperations studentOperations;

    @GetMapping("/students")
    public List<StudentContract> listStudents() {
        List<StudentContract> students = new ArrayList<>();
        List<StudentAws> studentItems = studentOperations.findAll();
        for (StudentAws studentItem: studentItems){
            StudentAws student = studentItem;
            students.add(new StudentContract(student));
        }
        return students;
    }
    @GetMapping("/students/{id}")
    public StudentContract getStudent (@PathVariable String id) {
        StudentAws studentItem = studentOperations.findById(id);
        return new StudentContract(studentItem);
    }
    @PostMapping("/students")
    public StudentContract createStudent (@RequestBody StudentContract newStudent) {
        StudentAws newStudentItem = studentOperations.save(new StudentAws(newStudent.getName(), newStudent.getAddress()));
        return new StudentContract(newStudentItem);
    }

    @PatchMapping("/students/{id}")
    public StudentContract updateStudent(@PathVariable String id, @RequestBody StudentContract updatedStudent) {
        StudentAws studentItem = studentOperations.findById(id);
        studentItem.setName(updatedStudent.getName());
        studentItem.setAddress(updatedStudent.getAddress());
        studentItem = studentOperations.save(studentItem);
        return new StudentContract(studentItem);
    }
}
