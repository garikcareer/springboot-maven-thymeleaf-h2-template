package com.example.springbootexample.service;

import com.example.springbootexample.model.Company;
import com.example.springbootexample.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company company, Long companyId) {
        if(companyRepository.findById(companyId).isPresent()){
            Company companyToUpdate = companyRepository.findById(companyId).get();
            if(Objects.nonNull(company.getName()) && !"".equalsIgnoreCase(company.getName())){
                companyToUpdate.setName(company.getName());
            }
            if(Objects.nonNull(company.getLocation()) && !"".equalsIgnoreCase(company.getLocation())){
                companyToUpdate.setLocation(company.getLocation());
            }
        }
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompanyById(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
