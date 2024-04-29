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

    @Override
    public Company saveCompany(Company company) {
        if (companyRepository.existsById(company.getId())) {
            throw new IllegalArgumentException("Cannot add the company. Company already exists with this id.");
        }
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company company, Long companyId) {
        Optional<Company> optionalCompanyToUpdate = companyRepository.findById(companyId);
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

    @Override
    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }

    @Override
    public boolean existsById(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        return companyOptional.isPresent();
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        } else {
            throw new NoSuchElementException("No company found with the provided id");
        }
    }
}
