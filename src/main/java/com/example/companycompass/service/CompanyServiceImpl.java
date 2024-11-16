package com.example.companycompass.service;

import com.example.companycompass.model.Company;
import com.example.companycompass.repository.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Create
    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    // Read
    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new EntityNotFoundException("Company not found"));
    }

    @Override
    public List<Company> getCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    // Update
    @Override
    public void updateCompany(Long companyId, Company company) {
        Company existingCompany = companyRepository.findById(companyId).orElseThrow(() ->
                new EntityNotFoundException("Company not found with id: " + companyId));
        existingCompany.setName(company.getName());
        existingCompany.setLocation(company.getLocation());
        companyRepository.save(existingCompany);
    }

    // Delete
    @Override
    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
