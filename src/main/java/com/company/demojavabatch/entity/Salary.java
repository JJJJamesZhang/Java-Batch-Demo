package com.company.demojavabatch.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Salary {
    public Salary(Integer empId, Project project, Double salary){
        this.empId = empId;
        this.project = project;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salaryid")
    private Integer salaryId;

    @Column(name = "empid")
    private Integer empId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "projectid")
    private Project project;

    @Column(name = "salary")
    private Double salary;
}
