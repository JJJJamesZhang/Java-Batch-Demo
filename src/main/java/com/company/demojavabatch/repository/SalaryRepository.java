package com.company.demojavabatch.repository;


import com.company.demojavabatch.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into Salary (EmpId, ProjectId, Salary) values (?1, ?2, ?3)", nativeQuery = true)
    void create(Integer empId, String projectId, Double salary);

    @Transactional
    @Modifying
    @Query(value = "update Salary set EmpId = ?2, ProjectId = ?3, Salary = ?4 where SalaryId = ?1 ", nativeQuery = true)
    void update(Integer salaryId, Integer empId, String projectId, Double salary);
}
