package com.company.demojavabatch.repository;


import com.company.demojavabatch.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    @Transactional
    @Modifying
    @Query(value = "insert into Project (ProjectId, ProjectName) values (?1, ?2)" ,nativeQuery = true)
    void create(String projectId, String projectName);

    @Transactional
    @Modifying
    @Query(value = "update Project set ProjectName = ?2 where ProjectId = ?1" , nativeQuery = true)
    void update(String projectId, String projectName);
}
