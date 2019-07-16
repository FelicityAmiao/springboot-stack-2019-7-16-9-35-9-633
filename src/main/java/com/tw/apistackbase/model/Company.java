package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static List<Company> createTestCompanies() {
        List<Company> companies = new ArrayList<>();
        Company company = new Company();
        company.setCompanyName("alibaba");
        company.setEmployeesNumber(1);
        company.setEmployees(Employee.createTestEmployees());
        companies.add(company);
        return companies;
    }
}
