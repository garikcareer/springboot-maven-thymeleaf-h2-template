package com.companycompass.service;

import com.companycompass.entity.Company;

import java.util.List;

public interface CompanyService {
    void addCompany(Company company);

    Company getCompanyById(Long companyId);

    List<Company> getCompanies();

    /**
     * Updates an existing company's information in the system.
     *
     * @param companyId the unique identifier of the company to be updated
     * @param company   the Company object containing the updated information
     */
    void updateCompany(Long companyId, Company company);

    /**
     * Deletes a company from the system based on the given company ID.
     *
     * @param companyId the unique identifier of the company to be deleted
     */
    void deleteCompanyById(Long companyId);
    
    
}
