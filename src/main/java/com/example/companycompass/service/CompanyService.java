package main.java.com.example.companycompass.service;

import main.java.com.example.companycompass.model.Company;

import java.util.List;

public interface CompanyService {
    Company saveCompany(Company company);

    Company getCompanyById(Long companyId);

    List<Company> getCompanies();

    Company updateCompany(Company company, Long companyId);

    void deleteCompanyById(Long companyId);

    boolean existsById(Long companyId);
}
