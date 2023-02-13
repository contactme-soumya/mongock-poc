package com.example.test.mongockpoc.config.dbmigrations;

import com.example.test.mongockpoc.domain.Department;
import com.example.test.mongockpoc.domain.Employee;
import io.mongock.api.annotations.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.stream.Stream;

@ChangeUnit(id="InitChangeUnitId", order = "1", author = "soumya", systemVersion = "1")
public class DatabaseInitChangeUnit {

    private final MongoTemplate mongoTemplate;

    public DatabaseInitChangeUnit(MongoTemplate template) {
        this.mongoTemplate = template;
    }
    //Note this method / annotation is Optional
    @BeforeExecution
    public void before() {
        //mongoTemplate.createCollection("department");
        //mongoTemplate.createCollection("employee");
        mongoTemplate.createCollection(Department.class);
        mongoTemplate.createCollection(Employee.class);
    }
    //Note this method / annotation is Optional
    @RollbackBeforeExecution
    public void rollbackBefore() {
        //mongoTemplate.dropCollection("clients");
    }
    @Execution
    public void migrationMethod() {
        //Stream.of(Department.builder().name("HR"), Department.builder().name("Payroll"), Department.builder().name("IT"));
        Stream.of(Department.builder().name("HR").build(), Department.builder().name("Payroll").build(), Department.builder().name("IT").build())
                .forEach(department -> mongoTemplate.save(department, "department"));

        Stream.of(Employee.builder().fname("John").lname("Doe").department(Department.builder().name("HR").build()).build(),
                Employee.builder().fname("Alister").lname("Cook").department(Department.builder().name("Payroll").build()).build(),
                        Employee.builder().fname("Gary").lname("Scott").department(Department.builder().name("IT").build()).build())
                .forEach(employee -> mongoTemplate.save(employee, "employee"));
    }
    @RollbackExecution
    public void rollback() {
        mongoTemplate.dropCollection("department");
        mongoTemplate.dropCollection("employee");
    }
}
