package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @GetMapping
    public List<Company> getAllCompanies() {
        List<Company> companies = Company.createTestCompanies();
        return companies;
    }

    @GetMapping("/{companyName}")
    public @ResponseBody Company getOneSpecifyCompany(@PathVariable String companyName) {
        Company company = Company.findCompanyByName(companyName);
        return company;
    }

    @GetMapping("/{companyName}/employees")
    public @ResponseBody List<Employee> getSpecifyCompanyEmployees(@PathVariable String companyName) {
        Company company = Company.findCompanyByName(companyName);
        return company.getEmployees();
    }
}
