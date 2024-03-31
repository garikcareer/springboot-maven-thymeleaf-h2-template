package com.example.companycompass.service;

import com.example.companycompass.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);

    List<Company> getCompanies();

    Company updateCompany(Company company, Long companyId);

    void deleteCompanyById(Long companyId);

    boolean existsById(Long companyId);
}
