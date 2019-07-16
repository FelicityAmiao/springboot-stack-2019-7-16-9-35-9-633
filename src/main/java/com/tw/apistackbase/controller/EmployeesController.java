package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployeesController {

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = Employee.createTestEmployees();
        return employees;
    }

    @GetMapping("/employees/{emplpyeeId}")
    public Employee getOneSpecifyEmployee(@PathVariable int emplpyeeId) {
        Employee employee = Employee.findEmployeesById(emplpyeeId);
        return employee;
    }

    @GetMapping("/employees{page}{pageSize}")
    public List<Employee> getEmployeesByPageAndPageSize(@RequestParam int page, @RequestParam int pageSize) {
        List<Employee> employees = Employee.findEmployeesByPageAndPageSize(page, pageSize);
        return employees;
    }

    @GetMapping("/employees{gender}")
    public List<Employee> getEmployeeByGender(@RequestParam String gender) {
        List<Employee> employees = Employee.findEmployeesByGender(gender);
        return employees;
    }

}
