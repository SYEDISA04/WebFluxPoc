package com.Poc.WebFluxPoc;
import org.springframework.data.annotation.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmpModel {

    @Id
    private String id;

    private String Name;
    private String Designation;
    private Long Salary;
    private int deptno;
}
