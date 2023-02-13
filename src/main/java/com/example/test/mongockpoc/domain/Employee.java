package com.example.test.mongockpoc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Builder
//@Document(collection = "employee")
public class Employee {
    @Id
    private Integer id;
    private String fname;
    private String lname;
    private Department department;

}
