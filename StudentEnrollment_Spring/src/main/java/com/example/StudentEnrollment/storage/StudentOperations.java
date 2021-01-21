package com.example.StudentEnrollment.storage;

import org.springframework.stereotype.Repository;

@Repository
public class StudentOperations extends BaseOperations {
    public Class tableClass = StudentAws.class;

    @Override
    public Class getTableClass(){
        return tableClass;
    }
}
