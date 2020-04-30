package com.company.demojavabatch.service;

import com.company.demojavabatch.entity.Employee;
import com.company.demojavabatch.entity.Salary;
import com.company.demojavabatch.repository.EmployeeRepository;
import com.company.demojavabatch.repository.SalaryRepository;
import com.company.demojavabatch.utils.CacheClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class EmployeeService {
    private  static final Logger log = LoggerFactory.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SalaryRepository salaryRepository;

    @Transactional(rollbackFor = Exception.class)
    public void create(Employee employee) {
        List<Salary> salaries = employee.getSalaries();
        salaries.forEach(s -> {
            salaryRepository.create(s.getEmpId(), s.getProject().getProjectId(), s.getSalary());
        });
        employeeRepository.create(employee.getEmpId(), employee.getFullName(), employee.getManagerId(), employee.getDateOfJoining());

    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Employee employee){
        List<Salary> salaries = employee.getSalaries();
        salaries.forEach(s -> {
            salaryRepository.update(s.getSalaryId(),s.getEmpId(),s.getProject().getProjectId(),s.getSalary());
        });
        employeeRepository.update(employee.getEmpId(),employee.getFullName(),employee.getManagerId(),employee.getDateOfJoining());
    }

    public Employee getById(Integer empId) {
        Long start = System.currentTimeMillis();
        JedisPool jedisPool = CacheClient.getJedisPool();
        try (Jedis jedis = jedisPool.getResource()){
            String employeeStr = jedis.get(Integer.toString(empId));
            if (employeeStr!= null && employeeStr.length() > 0){
                Employee employee = Employee.jsonToEmployee(employeeStr);
                log.info("Get employee function cost = {} ms",System.currentTimeMillis() - start);
                return employee;
            }
        }catch (Exception e){
            log.error("Redis exception = {}",e.getMessage());
//            System.out.println(e.getMessage());
        }
        Employee employee = employeeRepository.findById(empId).get();
        employee.getSalaries().forEach(salary -> {
            Double s = salary.getSalary();
            salary.setSalary(s + 10);
        });

        try (Jedis jedis = jedisPool.getResource()){
            String employeeStr = Employee.employeeToJson(employee);
            jedis.setex(Integer.toString(employee.getEmpId()),300,employeeStr);
        }catch (Exception e){
            log.error("Redis exception = {}",e.getMessage());
//            System.out.println(e.getMessage());
        }
        log.info("Get employee function cost = {} ms",System.currentTimeMillis() - start);
        return employee;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer empId){
        employeeRepository.deleteById(empId);
    }

    public List<Employee> list(){
        return employeeRepository.findAll();
    }
}
