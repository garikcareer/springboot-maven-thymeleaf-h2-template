package com.example.springbootexample.service;

import com.example.springbootexample.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);

    List<Company> getCompanies();

    Company updateCompany(Company company, Long companyId);

    void deleteCompanyById(Long companyId);
}
