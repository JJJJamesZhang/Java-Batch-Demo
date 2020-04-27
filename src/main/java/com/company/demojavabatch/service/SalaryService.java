package com.company.demojavabatch.service;

import com.company.demojavabatch.entity.Salary;
import com.company.demojavabatch.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(Salary salary){
        salaryRepository.create(salary.getEmpId(),salary.getProject().getProjectId(),salary.getSalary());
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer salaryId){
        salaryRepository.deleteById(salaryId);
    }
}
