package main.java.com.example.companycompass.repository;

import main.java.com.example.companycompass.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> { }
