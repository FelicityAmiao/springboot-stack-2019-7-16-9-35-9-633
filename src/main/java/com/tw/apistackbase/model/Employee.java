package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private int salary;

    public static Employee findEmployeesById(int emplpyeeId) {
        List<Employee> testEmployees = createTestEmployees();
        for(Employee employee: testEmployees) {
            if(employee.id == emplpyeeId) {
                return employee;
            }
        }
        return null;
    }

    public static List<Employee> findEmployeesByPageAndPageSize(int page, int pageSize) {
        List<Employee> testEmployees = createTestEmployees();
        List<Employee> resultEmployees = new ArrayList<>();
        for (int i = page-1; i < pageSize && i < testEmployees.size(); i++) {
            resultEmployees.add(testEmployees.get(i));
        }
        return resultEmployees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static List<Employee> createTestEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(4);
        employee.setName("alibaba1");
        employee.setAge(20);
        employee.setGender("male");
        employee.setSalary(6000);
        employees.add(employee);
        return employees;
    }
}
