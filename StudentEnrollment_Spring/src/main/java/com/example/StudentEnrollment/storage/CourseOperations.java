package com.example.StudentEnrollment.storage;

import org.springframework.stereotype.Repository;
@Repository
public class CourseOperations extends BaseOperations{

    public Class tableClass = CourseAws.class;

    @Override
    public Class getTableClass(){
        return tableClass;
    }
}
