package com.example.StudentEnrollment.contracts;
import com.example.StudentEnrollment.storage.CourseAws;

public class CourseContract {
    public String id;
    public String name;
    public String description;

    public CourseContract(String name) {
        this.name = name;
    }

    public CourseContract(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CourseContract(CourseAws courseItem) {
        this.id = courseItem.getId();
        this.name = courseItem.getName();
        this.description = courseItem.getDescription();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription() { this.description = description; }
}
