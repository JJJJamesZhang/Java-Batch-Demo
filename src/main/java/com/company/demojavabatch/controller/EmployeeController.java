package com.company.demojavabatch.controller;

import com.company.demojavabatch.entity.Employee;
import com.company.demojavabatch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "get/{empId}")
    public Employee get(@PathVariable(value = "empId") Integer empId){
        return employeeService.getById(empId);
    }

    @GetMapping(value = "list")
    public List<Employee> list(){
        return employeeService.list();
    }

    @PostMapping(value = "create")
    public void create(@RequestBody Employee employee){
        employeeService.create(employee);
    }

    @PutMapping(value = "update")
    public void update(@RequestBody Employee employee){
        employeeService.update(employee);
    }

    @DeleteMapping(value = "delete/{empId}")
    public void delete(@PathVariable("empId") Integer empId){
        employeeService.deleteById(empId);
    }
}
