package com.company.demojavabatch.repository;


import com.company.demojavabatch.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into Employee (EmpId, FullName, ManagerId, DateOfJoining) values  (?1, ?2, ?3, ?4)" , nativeQuery = true)
    void create(Integer empId, String fullName, String managerId, String dateOfJoining);

    @Transactional
    @Modifying
    @Query(value = "update Employee set FullName = ?2, ManagerId = ?3, DateOfJoining = ?4 where EmpId = ?1", nativeQuery = true)
    void update(Integer empId, String fullName, String managerId, String dateOfJoining);
}
