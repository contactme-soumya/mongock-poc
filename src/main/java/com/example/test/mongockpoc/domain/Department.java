package com.example.test.mongockpoc.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
@Builder
//@Document(collection = "department")
public class Department {
    private Integer id;
    private String name;
}
