package com.example.companycompass.service;

import com.example.companycompass.model.Company;
import com.example.companycompass.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    // Create
    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Read
    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        } else {
            throw new NoSuchElementException("No company found with the provided id");
        }
    }

    @Override
    public List<Company> getCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    // Update
    @Override
    public Company updateCompany(Company company) {
        Optional<Company> optionalCompanyToUpdate = companyRepository.findById(company.getId());
        if (optionalCompanyToUpdate.isPresent()) {
            Company companyToUpdate = optionalCompanyToUpdate.get();
            if (Objects.nonNull(company.getName()) && !"".equalsIgnoreCase(company.getName())) {
                companyToUpdate.setName(company.getName());
            }
            if (Objects.nonNull(company.getLocation()) && !"".equalsIgnoreCase(company.getLocation())) {
                companyToUpdate.setLocation(company.getLocation());
            }
            return companyRepository.save(companyToUpdate);
        }
        return null;
    }

    // Delete
    @Override
    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
