package com.example.StudentEnrollment.config;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration {

    private String amazonAWSAccessKey = "test_access_key";
    private String amazonAWSSecretKey = "test_secret_key";
    private String awsDynamoDBUrl = "http://localhost:8000";

    @Bean
    public AWSStaticCredentialsProvider amazonAWSCredentials() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey));
    }

    @Bean
    public AmazonDynamoDB dynamoDB(AWSStaticCredentialsProvider amazonAWSCredentials){
        AmazonDynamoDB dynamo = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsDynamoDBUrl, Regions.US_EAST_1.name()))
                .withCredentials(amazonAWSCredentials)
                .build();
        return dynamo;
    }

    @Bean
    public DynamoDBMapper dbMapper (AmazonDynamoDB dynamoDB) {
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);
        return mapper;
    }

}
