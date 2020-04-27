package com.company.demojavabatch.controller;

import com.company.demojavabatch.entity.Salary;
import com.company.demojavabatch.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping(value = "create")
    public void create(@RequestBody Salary salary){
        salaryService.create(salary);
    }

    @DeleteMapping(value = "delete/{salaryId}")
    public void delete(@PathVariable("salaryId") Integer salaryId){
        salaryService.deleteById(salaryId);
    }
}
