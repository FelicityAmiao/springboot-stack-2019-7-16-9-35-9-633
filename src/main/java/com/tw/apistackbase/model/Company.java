package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees;

    public static Company findCompanyByName(String companyName) {
        List<Company> testCompanies = createTestCompanies();
        for(Company company: testCompanies) {
            if(company.companyName.equals(companyName)) {
                return company;
            }
        }
        return null;
    }

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

        Company company1 = new Company();
        company1.setCompanyName("1");
        company1.setEmployeesNumber(1);
        company1.setEmployees(Employee.createTestEmployees());
        companies.add(company1);
        return companies;
    }

}
