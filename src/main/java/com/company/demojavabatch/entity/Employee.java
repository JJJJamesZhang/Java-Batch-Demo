package com.company.demojavabatch.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.persistence.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee{

    @Id
    @Column(name = "empid")
    private Integer empId;

    @Column(name = "fullname")
    private String fullName;

    @Column(name="managerid")
    private String managerId;

    @Column(name = "dateofjoining")
    private String dateOfJoining;

    @OneToMany(mappedBy = "empId",fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private List<Salary> salaries;

    public static String employeeToJson(Employee employee) throws JsonProcessingException {
        String jsonStr = new ObjectMapper().writeValueAsString(employee);
        return jsonStr;
    }

    public static Employee jsonToEmployee(String jsonStr) throws JsonProcessingException {
        Employee employee = new ObjectMapper().readValue(jsonStr,Employee.class);
        return employee;
    }

    public static void main(String[] args) throws JsonProcessingException {
        Employee employee = new Employee(121,"Jack","345","2019-09-01", Arrays.asList(new Salary(1,new Project("p1","website"),8000d)));
        String str = employeeToJson(employee);
        System.out.println(str);
        Employee employee1 = jsonToEmployee(str);
        System.out.println(employee1);
    }
}
