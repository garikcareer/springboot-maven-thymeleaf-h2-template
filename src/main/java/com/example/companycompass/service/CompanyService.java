package com.example.companycompass.service;

import com.example.companycompass.model.Company;

import java.util.List;

public interface CompanyService {
    void addCompany(Company company);

    Company getCompanyById(Long companyId);

    List<Company> getCompanies();

    void updateCompany(Long companyId, Company company);

    void deleteCompanyById(Long companyId);
}
