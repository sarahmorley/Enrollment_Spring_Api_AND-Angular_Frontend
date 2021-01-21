package com.example.StudentEnrollment.storage;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Repository
public class BaseOperations {

    @Autowired
    private DynamoDBMapper mapper;

    public Class tableClass;

    public Class getTableClass(){
        return tableClass;
    }

    public <T> List<T> findAll(){
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        List<T> items = mapper.scan(this.getTableClass(), scanExpression);
        return items;
    }

    public <T> T findById(String id){
        return (T) mapper.load(this.getTableClass(), id);
    }

    public <T> T findById(String hashKey, String rangeKey){
        return (T) mapper.load(this.getTableClass(), hashKey, rangeKey);
    }

    public <T> T save(T itemToSave){
        mapper.save(itemToSave);
        return (T) itemToSave;
    }

}
