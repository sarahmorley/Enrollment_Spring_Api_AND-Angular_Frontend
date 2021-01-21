package com.example.StudentEnrollment.contracts;
import com.example.StudentEnrollment.storage.StudentAws;

public class StudentContract {

    public String id;
    public String name;
    public String address;

    public StudentContract(String name) {
        this.name = name;
    }

    public StudentContract(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public StudentContract(StudentAws studentItem) {
        this.id = studentItem.getId();
        this.name = studentItem.getName();
        this.address = studentItem.getAddress();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() { return address; }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress() { this.address = address; }

}
