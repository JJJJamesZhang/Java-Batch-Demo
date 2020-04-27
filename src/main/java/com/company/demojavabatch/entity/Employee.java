package com.company.demojavabatch.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

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

}
