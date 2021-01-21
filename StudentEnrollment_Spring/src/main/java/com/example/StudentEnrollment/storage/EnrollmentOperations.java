package com.example.StudentEnrollment.storage;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EnrollmentOperations extends BaseOperations{

    @Autowired
    private DynamoDBMapper mapper;

    public Class tableClass = EnrollmentAws.class;

    @Override
    public Class getTableClass(){
        return tableClass;
    }

    public List<EnrollmentAws> findByHashKey (String hashKey) {
        EnrollmentAws enrollmentValues = new EnrollmentAws();
        enrollmentValues.setCourseId(hashKey);
        DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression();
        queryExpression.withHashKeyValues(enrollmentValues);
        List<EnrollmentAws> enrollmentList = mapper.query(EnrollmentAws.class, queryExpression);
        return enrollmentList;
    }

}
