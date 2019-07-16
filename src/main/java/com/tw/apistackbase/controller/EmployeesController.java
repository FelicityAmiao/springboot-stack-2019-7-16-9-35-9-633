package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> employees = Employee.createTestEmployees();
        return employees;
    }

    @GetMapping("/{emplpyeeId}")
    public Employee getOneSpecifyEmployee(@PathVariable int emplpyeeId) {
        Employee employee = Employee.findEmployeesById(emplpyeeId);
        return employee;
    }

    @GetMapping("{page}{pageSize}")
    public List<Employee> getEmployeesByPageAndPageSize(@RequestParam int page, @RequestParam int pageSize) {
        List<Employee> employees = Employee.findEmployeesByPageAndPageSize(page, pageSize);
        return employees;
    }

}
