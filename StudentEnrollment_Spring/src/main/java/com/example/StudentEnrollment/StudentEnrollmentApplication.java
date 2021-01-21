package com.example.StudentEnrollment;
import com.example.StudentEnrollment.storage.CourseAws;
import com.example.StudentEnrollment.storage.EnrollmentAws;
import com.example.StudentEnrollment.storage.StudentAws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StudentEnrollmentApplication {
	@Autowired
	private DynamoDBMapper mapper;
	@Autowired
	private AmazonDynamoDB dynamoDB;


	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(StudentEnrollmentApplication.class, args);
		DynamoDBMapper mapper = appContext.getBean(DynamoDBMapper.class);
		AmazonDynamoDB dynamoDB = appContext.getBean(AmazonDynamoDB.class);

		CreateTableRequest createStudentTableRequest = mapper.generateCreateTableRequest(StudentAws.class)
				.withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(dynamoDB, createStudentTableRequest);

		CreateTableRequest createCourseTableRequest = mapper.generateCreateTableRequest(CourseAws.class)
				.withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(dynamoDB, createCourseTableRequest);

		CreateTableRequest createEnrollmentTableRequest = mapper.generateCreateTableRequest(EnrollmentAws.class)
				.withProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(dynamoDB, createEnrollmentTableRequest);

		try {
			TableUtils.waitUntilActive(dynamoDB, createStudentTableRequest.getTableName());
			TableUtils.waitUntilActive(dynamoDB, createCourseTableRequest.getTableName());
			TableUtils.waitUntilActive(dynamoDB, createEnrollmentTableRequest.getTableName());
		} catch (Exception exception){
			System.exit(1);
		}

	}
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

}
