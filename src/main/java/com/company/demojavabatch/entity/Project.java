package com.company.demojavabatch.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project{

    @Id
    @Column(name = "projectid")
    private String projectId;

    @Column(name = "projectname")
    private String projectName;
}
