package com.example.companycompass.controller;

import com.example.companycompass.model.Company;
import com.example.companycompass.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path = "/api/company")
public class CompanyRestController {
    @Autowired
    private CompanyService companyService;

    @PostMapping(path = "/add")
    public @ResponseBody Company addCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @GetMapping("/get/{companyId}")
    public @ResponseBody Company getCompany(@PathVariable Long companyId, Model model) {
        return companyService.getCompanyById(companyId);
    }

    @GetMapping(path = "/get/all")
    public @ResponseBody List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @PutMapping(path = "/update/{id}")
    public String updateCompany(@RequestBody Company company,
                                @PathVariable("id") Long companyId) {
        Company updatedCompany = companyService.updateCompany(company, companyId);
        return "Company with ID (" + companyId + ") updated successfully with values: " + updatedCompany;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCompanyById(@PathVariable("id") Long companyId) {
        companyService.deleteCompanyById(companyId);
        return "Company with ID (" + companyId + ") deleted successfully.";
    }
}
